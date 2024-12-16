package io.jmix.petclinic.view.owner;

import com.vaadin.flow.component.html.H3;
import com.vaadin.flow.router.Route;
import io.jmix.core.Metadata;
import io.jmix.flowui.Notifications;
import io.jmix.flowui.component.grid.DataGrid;
import io.jmix.flowui.kit.action.ActionPerformedEvent;
import io.jmix.flowui.model.CollectionPropertyContainer;
import io.jmix.flowui.model.DataContext;
import io.jmix.flowui.view.*;
import io.jmix.petclinic.entity.owner.Address;
import io.jmix.petclinic.entity.owner.Owner;
import io.jmix.petclinic.view.main.MainView;
import org.springframework.beans.factory.annotation.Autowired;

// tag::start-class[]
@Route(value = "owners/:id", layout = MainView.class)
@ViewController("petclinic_Owner.detail")
@ViewDescriptor("owner-detail-view.xml")
@EditedEntityContainer("ownerDc")
public class OwnerDetailView extends StandardDetailView<Owner> {

    @ViewComponent
    private MessageBundle messageBundle;
    @ViewComponent
    private DataGrid<Address> addressesDataGrid;
    @ViewComponent
    private CollectionPropertyContainer<Address> addressesDc;
    @Autowired
    protected Notifications notifications;
    // end::start-class[]

    @ViewComponent
    private H3 nameHeader;
    @ViewComponent
    private DataContext dataContext;

    // tag::create[]
    @Subscribe("addressesDataGrid.create")
    protected void onAddressesDataGridCreate(ActionPerformedEvent event) {
        if (addressesDataGrid.getEditor().isOpen()) {
            notifications.create("Close the editor before creating a new entity")
                    .withType(Notifications.Type.WARNING)
                    .withCloseable(false)
                    .show();
            return;
        }

        Address newAddress = dataContext.create(Address.class); // <1>

        newAddress.setOwner(getEditedEntity()); // <2>
        addressesDc.getMutableItems().add(newAddress); // <3>

        addressesDataGrid.select(newAddress);
        addressesDataGrid.getEditor().editItem(newAddress); // <4>

    }
    // end::create[]

    // tag::edit[]
    @Subscribe("addressesDataGrid.edit")
    protected void onAddressesDataGridEdit(ActionPerformedEvent event) {
        Address selectedAddress = addressesDataGrid.getSingleSelectedItem();

        if (selectedAddress == null || addressesDataGrid.getEditor().isOpen()) {
            notifications.create(messageBundle.getMessage("editAlreadyOpened"))
                    .withType(Notifications.Type.WARNING)
                    .withCloseable(false)
                    .show();
            return;
        }

        addressesDataGrid.getEditor().editItem(selectedAddress);
    }
    // end::edit[]


    @Subscribe
    public void onReady(final ReadyEvent event) {
        nameHeader.setText(messageBundle.formatMessage("ownerNameHeader", getEditedEntity().getFullName()));
    }

// tag::end-class[]
}
// end::end-class[]