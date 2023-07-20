package ru.oorzhak.mywaytest;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.textfield.IntegerField;
import com.vaadin.flow.data.binder.Binder;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.spring.annotation.SpringComponent;
import org.springframework.beans.factory.annotation.Autowired;
import ru.oorzhak.mywaytest.model.Change;
import ru.oorzhak.mywaytest.service.ChangeService;

@Route("")
@PageTitle("Main Page")
@SpringComponent
public class MainView extends HorizontalLayout {
    private final ChangeService changeService;
    public final Button decrementButton = new Button("-");
    public final Button incrementButton = new Button("+");
    public final IntegerField integerField = new IntegerField();
    public final HorizontalLayout horizontalLayout = new HorizontalLayout(decrementButton, integerField, incrementButton);
    public final Binder<Change> binder = new Binder<>(Change.class);

    @Autowired
    public MainView(ChangeService changeService) {
        this.changeService = changeService;
        changeService.update((long) 0);
        integerField.setValue(0);
        decrementButton.addClickListener(e -> {
            int curValue = integerField.getValue();
            int newValue = this.changeService.decrement((long) curValue).intValue();
            integerField.setValue(newValue);
        });
        incrementButton.addClickListener(e -> {
            int curValue = integerField.getValue();
            int newValue = this.changeService.increment((long) curValue).intValue();
            integerField.setValue(newValue);
        });
        integerField.addValueChangeListener(e -> {
            this.changeService.update(e.getValue().longValue());
        });
        add(horizontalLayout);
    }
}
