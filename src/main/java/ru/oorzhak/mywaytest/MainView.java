package ru.oorzhak.mywaytest;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.textfield.IntegerField;
import com.vaadin.flow.data.binder.Binder;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.spring.annotation.SpringComponent;
import com.vaadin.flow.spring.annotation.UIScope;
import org.springframework.beans.factory.annotation.Autowired;
import ru.oorzhak.mywaytest.model.Change;
import ru.oorzhak.mywaytest.service.ChangeService;

@Route("")
@PageTitle("Main Page")
@SpringComponent
public class MainView extends HorizontalLayout {
    private final ChangeService changeService;
    private final Button decrementButton = new Button("-");
    private final Button incrementButton = new Button("+");
    private final IntegerField integerField = new IntegerField();
    private final HorizontalLayout horizontalLayout = new HorizontalLayout(decrementButton, integerField, incrementButton);
    private final Binder<Change> binder = new Binder<>(Change.class);

    @Autowired
    public MainView(ChangeService changeService) {
        this.changeService = changeService;
        changeService.update((long) 0);
        integerField.setValue(0);
        decrementButton.addClickListener((buttonClickEvent) -> {
            int curValue = integerField.getValue();
            int newValue = this.changeService.decrement((long) curValue).intValue();
            integerField.setValue(newValue);
        });
        incrementButton.addClickListener((buttonClickEvent) -> {
            int curValue = integerField.getValue();
            int newValue = this.changeService.increment((long) curValue).intValue();
            integerField.setValue(newValue);
        });
        integerField.addValueChangeListener(e -> {
            if (!e.isFromClient()) return;
            this.changeService.update(e.getValue().longValue());
        });
        add(horizontalLayout);
    }
}
