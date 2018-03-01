import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ListViewWithImages extends Application {

    private final Image IMAGE_RUBY  = new Image("https://upload.wikimedia.org/wikipedia/commons/f/f1/Ruby_logo_64x64.png");
    private final Image IMAGE_APPLE  = new Image("http://findicons.com/files/icons/832/social_and_web/64/apple.png");
    private final Image IMAGE_VISTA  = new Image("http://antaki.ca/bloom/img/windows_64x64.png");
    private final Image IMAGE_TWITTER = new Image("http://files.softicons.com/download/social-media-icons/fresh-social-media-icons-by-creative-nerds/png/64x64/twitter-bird.png");

    private Image[] listOfImages = {IMAGE_RUBY, IMAGE_APPLE, IMAGE_VISTA, IMAGE_TWITTER};

    @Override
    public void start(Stage primaryStage) throws Exception {

        ListView<String> listView = new ListView<String>();
        ObservableList<String> items =FXCollections.observableArrayList (
                "RUBY", "APPLE", "VISTA", "TWITTER");
        listView.setItems(items);

        listView.setCellFactory(param -> new ListCell<String>() {
            private ImageView imageView = new ImageView();
            @Override
            public void updateItem(String name, boolean empty) {
                super.updateItem(name, empty);
                if (empty) {
                    setText(null);
                    setGraphic(null);
                } else {
                    if(name.equals("RUBY"))
                        imageView.setImage(listOfImages[0]);
                    else if(name.equals("APPLE"))
                        imageView.setImage(listOfImages[1]);
                    else if(name.equals("VISTA"))
                        imageView.setImage(listOfImages[2]);
                    else if(name.equals("TWITTER"))
                        imageView.setImage(listOfImages[3]);
                    setText(name);
                    setGraphic(imageView);
                }
            }
        });
        VBox box = new VBox(listView);
        box.setAlignment(Pos.CENTER);
        Scene scene = new Scene(box, 200, 200);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
