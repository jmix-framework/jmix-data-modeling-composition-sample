package io.jmix.petclinic.view.coverage.coveragedetails;

import com.vaadin.flow.router.Route;
import io.jmix.flowui.view.EditedEntityContainer;
import io.jmix.flowui.view.StandardDetailView;
import io.jmix.flowui.view.ViewController;
import io.jmix.flowui.view.ViewDescriptor;
import io.jmix.petclinic.entity.coverage.CoverageDetails;
import io.jmix.petclinic.view.main.MainView;

@Route(value = "coverageDetailses/:id", layout = MainView.class)
@ViewController(id = "petclinic_CoverageDetails.detail")
@ViewDescriptor(path = "coverage-details-detail-view.xml")
@EditedEntityContainer("coverageDetailsDc")
public class CoverageDetailsDetailView extends StandardDetailView<CoverageDetails> {
}