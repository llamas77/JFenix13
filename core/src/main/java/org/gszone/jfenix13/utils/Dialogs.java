package org.gszone.jfenix13.utils;

import com.badlogic.gdx.Input;
import com.badlogic.gdx.scenes.scene2d.*;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.kotcrab.vis.ui.widget.ButtonBar;
import com.kotcrab.vis.ui.widget.VisDialog;
import org.gszone.jfenix13.Main;

public class Dialogs {
    public static VisDialog showOKDialog (String title, String text) {
        final Stage s = Main.getInstance().getCurrentView().getStage();
        final Actor a = s.getKeyboardFocus();

        final VisDialog dialog = new VisDialog(title);
        dialog.closeOnEscape();
        dialog.text(text);
        dialog.button(ButtonBar.ButtonType.OK.getText()).padBottom(3);
        dialog.pack();
        dialog.centerWindow();
        dialog.addListener(new InputListener() {
            @Override
            public boolean keyDown (InputEvent event, int keycode) {
                if (keycode == Input.Keys.ENTER) {
                    dialog.fadeOut();
                    // TODO: devolver el foco al textfield
                    return true;
                }
                return false;
            }
        });

        s.addActor(dialog.fadeIn());
        return dialog;
    }
}