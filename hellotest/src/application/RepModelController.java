package application;

import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.util.Callback;
import java.io.File;
import java.util.List;

public class RepModelController {
    @FXML
    private ListView<File> fileListView;

    @FXML
    private Button deleteButton;


    @FXML
    private void initialize() {
        List<File> modelFiles = getModelFiles();

        // Configurer la cellule de la ListView
        fileListView.setCellFactory(new Callback<ListView<File>, ListCell<File>>() {
            @Override
            public ListCell<File> call(ListView<File> listView) {
                return new FileListCell();
            }
        });

        fileListView.getItems().addAll(modelFiles);
    }
    private List<File> getModelFiles() {
        File directory = new File("/home/nas-wks01/users/uapv2200719/eclipse-workspace/exam/src/exam/hellotest/models");
        File[] files = directory.listFiles();

        if (files != null) {
            return List.of(files);
        }

        return List.of(); // Retourne une liste vide si aucun fichier trouvé
    }

    // Classe interne pour configurer la cellule de la ListView
    private static class FileListCell extends ListCell<File> {
        private final CheckBox checkBox;

        public FileListCell() {
            this.checkBox = new CheckBox();
        }
        @Override
        protected void updateItem(File file, boolean empty) {
            super.updateItem(file, empty);

            if (empty || file == null) {
                setText(null);
                setGraphic(null);
            } else {

                HBox hbox = new HBox(new Label(file.getName()),checkBox);
                hbox.setSpacing(10);

                setGraphic(hbox);
            }
        }

        public CheckBox getCheckBox() {
            return checkBox;
        }
    }
    @FXML
    private void deleteSelectedFiles() {

        List<File> selectedFiles = fileListView.getItems().filtered(file -> {
            FileListCell cell = findCellForItem(fileListView, file);
            return cell != null && cell.getCheckBox().isSelected();
        });
        System.out.println(selectedFiles);
        // Supprimer les fichiers sélectionnés
        selectedFiles.forEach(file -> {
            if (file.delete()) {
                System.out.println("Fichier supprimé : " + file.getName());
            } else {
                System.out.println("Échec de la suppression du fichier : " + file.getName());
            }
        });

        // Rafraîchir la liste après la suppression
        fileListView.getItems().removeAll(selectedFiles);
    }

    private FileListCell findCellForItem(ListView<File> listView, File item) {
        for (Node node : listView.lookupAll(".list-cell")) {
            ListCell<File> cell = (ListCell<File>) node;
            if (cell.getItem() == item) {
                return (FileListCell) cell;
            }
        }
        return null;
    }
}