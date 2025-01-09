package io.jmix.petclinic.view.coverage.insuranceprovider;

import com.vaadin.flow.router.Route;
import io.jmix.flowui.view.EditedEntityContainer;
import io.jmix.flowui.view.StandardDetailView;
import io.jmix.flowui.view.ViewController;
import io.jmix.flowui.view.ViewDescriptor;
import io.jmix.petclinic.entity.coverage.InsuranceProvider;
import io.jmix.petclinic.view.main.MainView;

@Route(value = "insuranceProviders/:id", layout = MainView.class)
@ViewController(id = "petclinic_InsuranceProvider.detail")
@ViewDescriptor(path = "insurance-provider-detail-view.xml")
@EditedEntityContainer("insuranceProviderDc")
public class InsuranceProviderDetailView extends StandardDetailView<InsuranceProvider> {
}