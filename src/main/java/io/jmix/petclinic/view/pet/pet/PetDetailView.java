package io.jmix.petclinic.view.pet.pet;

import io.jmix.core.MetadataTools;
import io.jmix.core.UuidProvider;
import io.jmix.flowui.DialogWindows;
import io.jmix.flowui.component.grid.DataGrid;
import io.jmix.flowui.kit.action.ActionPerformedEvent;
import io.jmix.flowui.model.DataContext;
import io.jmix.petclinic.entity.health.HealthRecord;
import io.jmix.petclinic.entity.pet.Pet;

import io.jmix.petclinic.view.main.MainView;

import com.vaadin.flow.router.Route;
import io.jmix.flowui.view.*;
import org.springframework.beans.factory.annotation.Autowired;

@Route(value = "pets/:id", layout = MainView.class)
@ViewController("petclinic_Pet.detail")
@ViewDescriptor("pet-detail-view.xml")
@EditedEntityContainer("petDc")
@DialogMode(height = "64em")
public class PetDetailView extends StandardDetailView<Pet> {
    @ViewComponent
    private DataGrid<HealthRecord> healthRecordsDataGrid;
    @ViewComponent
    private DataContext dataContext;
    @Autowired
    private DialogWindows dialogWindows;

    // tag::next-checkup[]
    @Subscribe("healthRecordsDataGrid.nextCheckup")
    public void onHealthRecordsDataGridNextCheckup(final ActionPerformedEvent event) {
        HealthRecord originalHealthRecord = healthRecordsDataGrid.getSingleSelectedItem();

        dialogWindows.detail(healthRecordsDataGrid) // <1>
                .newEntity()
                .withInitializer(healthRecord -> {
                    healthRecord.setPet(originalHealthRecord.getPet()); // <2>
                    healthRecord.setRecordDate(originalHealthRecord.getNextCheckupDate());
                    healthRecord.setHealthStatus(originalHealthRecord.getHealthStatus());
                    healthRecord.setDiagnosis(originalHealthRecord.getDiagnosis());
                    healthRecord.setMedication(originalHealthRecord.getMedication());
                })
                .withParentDataContext(dataContext) // <3>
                .open();
    }
    // end::next-checkup[]

}