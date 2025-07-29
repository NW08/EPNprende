package main.java.utils;

import javafx.animation.FadeTransition;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.layout.StackPane;
import javafx.util.Duration;
import main.java.interfaces.ViewLifecycle;
import main.kotlin.utils.ResourceLoader;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * ScreenManager con cache, fade in/out y hooks onShow/onHide.
 */
public enum ScreenManager {
   ;

   private static final Map<String, ViewHolder> cache = new HashMap<>();
   private static StackPane root;
   private static ViewHolder current;

   public static void init(StackPane rootPane) {
      root = rootPane;
   }

   public static void show(String fxmlPath) {
      if (root == null) throw new IllegalStateException(Strings.ERROR_SCREEN_MANAGER_NOT_INITIALIZED.getText());

      ViewHolder next = cache.computeIfAbsent(fxmlPath, ScreenManager::load);
      fadeSwitch(next);
   }

   private static void fadeSwitch(ViewHolder next) {
      if (current != null && current.controller instanceof ViewLifecycle vl) vl.onHide();

      Parent newView = next.root;
      if (root.getChildren().isEmpty()) {
         root.getChildren().setAll(newView);
         fadeIn(newView);
         if (next.controller instanceof ViewLifecycle vl) vl.onShow();
      } else {
         Parent oldView = (Parent) root.getChildren().getFirst();
         FadeTransition fadeOut = new FadeTransition(Duration.millis(300), oldView);
         fadeOut.setFromValue(1.0);
         fadeOut.setToValue(0.0);
         fadeOut.setOnFinished(_ -> {
            root.getChildren().setAll(newView);
            fadeIn(newView);
            if (next.controller instanceof ViewLifecycle vl) vl.onShow();
         });
         fadeOut.play();
      }
      current = next;
   }

   private static void fadeIn(Parent view) {
      FadeTransition fadeIn = new FadeTransition(Duration.millis(300), view);
      fadeIn.setFromValue(0.0);
      fadeIn.setToValue(1.0);
      fadeIn.play();
   }

   private static ViewHolder load(String path) {
      try {
         FXMLLoader loader = new FXMLLoader(ResourceLoader.INSTANCE.getResource$EPNprende(path));
         Parent root = loader.load();
         Object controller = loader.getController();
         return new ViewHolder(root, controller);
      } catch (IOException ex) {
         throw new RuntimeException("Error cargando FXML: " + path, ex);
      }
   }

   private record ViewHolder(Parent root, Object controller) {
   }
}