package io.jmix.petclinic.view.owner.address;

import com.vaadin.flow.router.Route;
import io.jmix.flowui.view.EditedEntityContainer;
import io.jmix.flowui.view.StandardDetailView;
import io.jmix.flowui.view.ViewController;
import io.jmix.flowui.view.ViewDescriptor;
import io.jmix.petclinic.entity.owner.Address;
import io.jmix.petclinic.view.main.MainView;

@Route(value = "addresses/:id", layout = MainView.class)
@ViewController(id = "petclinic_Address.detail")
@ViewDescriptor(path = "address-detail-view.xml")
@EditedEntityContainer("addressDc")
public class AddressDetailView extends StandardDetailView<Address> {
}