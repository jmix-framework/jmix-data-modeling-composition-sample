package io.jmix.petclinic.view.health.healthrecord;

import com.vaadin.flow.router.Route;
import io.jmix.core.TimeSource;
import io.jmix.flowui.view.*;
import io.jmix.petclinic.entity.health.HealthRecord;
import io.jmix.petclinic.view.main.MainView;
import org.springframework.beans.factory.annotation.Autowired;

@Route(value = "healthRecords/:id", layout = MainView.class)
@ViewController(id = "petclinic_HealthRecord.detail")
@ViewDescriptor(path = "health-record-detail-view.xml")
@EditedEntityContainer("healthRecordDc")
@DialogMode(width = "40em", height = "60em")
public class HealthRecordDetailView extends StandardDetailView<HealthRecord> {
    @Autowired
    private TimeSource timeSource;

    @Subscribe
    public void onInitEntity(final InitEntityEvent<HealthRecord> event) {
        event.getEntity().setRecordDate(timeSource.now().toLocalDate());
    }

}