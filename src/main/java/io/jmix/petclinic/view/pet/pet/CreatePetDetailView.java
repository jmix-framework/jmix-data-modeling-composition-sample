package io.jmix.petclinic.view.pet.pet;

import com.vaadin.flow.component.AbstractField;
import com.vaadin.flow.component.AbstractSinglePropertyField;
import com.vaadin.flow.component.HasEnabled;
import com.vaadin.flow.component.HasValue;
import com.vaadin.flow.router.Route;
import io.jmix.flowui.component.combobox.EntityComboBox;
import io.jmix.flowui.component.select.JmixSelect;
import io.jmix.flowui.component.textfield.TypedTextField;
import io.jmix.flowui.model.DataContext;
import io.jmix.flowui.model.InstancePropertyContainer;
import io.jmix.flowui.view.*;
import io.jmix.petclinic.entity.coverage.CoverageDetails;
import io.jmix.petclinic.entity.coverage.CoverageType;
import io.jmix.petclinic.entity.coverage.InsuranceProvider;
import io.jmix.petclinic.entity.pet.Pet;
import io.jmix.petclinic.view.main.MainView;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigDecimal;
import java.util.List;


// tag::start-class[]
@Route(value = "pet-create/:id", layout = MainView.class)
@ViewController(id = "petclinic_Pet.create")
@ViewDescriptor(path = "create-pet-detail-view.xml")
@EditedEntityContainer("petDc")
public class CreatePetDetailView extends StandardDetailView<Pet> {
    // end::start-class[]

    // tag::coverage-details-initialisation[]
    @ViewComponent
    private DataContext dataContext;

    @Subscribe
    public void onInitEntity(final InitEntityEvent<Pet> event) {  // <1>
        CoverageDetails coverageDetails = dataContext.create(CoverageDetails.class);  // <2>
        event.getEntity().setCoverageDetails(coverageDetails); // <3>
    }

    // end::coverage-details-initialisation[]

    @ViewComponent
    private EntityComboBox<InsuranceProvider> insuranceProviderField;
    @ViewComponent
    private TypedTextField<Double> coveragePercentageField;
    @ViewComponent
    private TypedTextField<BigDecimal> maxCoverageAmountField;
    @ViewComponent
    private TypedTextField<String> policyNumberField;

    @Subscribe("coverageTypeField")
    public void onCoverageTypeFieldComponentValueChange(final AbstractField.ComponentValueChangeEvent<JmixSelect<CoverageType>, CoverageType> event) {

        if (CoverageType.INSURANCE.equals(event.getValue())) {
            coveragePercentageField.setEnabled(true);
            insuranceProviderField.setEnabled(true);
            maxCoverageAmountField.setEnabled(true);
            policyNumberField.setEnabled(true);
        }
        else {
            coveragePercentageField.setEnabled(false);
            insuranceProviderField.setEnabled(false);
            maxCoverageAmountField.setEnabled(false);
            policyNumberField.setEnabled(false);

            coveragePercentageField.setValue(null);
            insuranceProviderField.setValue(null);
            maxCoverageAmountField.setValue(null);
            policyNumberField.setValue(null);

        }
    }

// tag::end-class[]
}
// end::end-class[]