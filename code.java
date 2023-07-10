
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class java_theory_da extends Application {

    public static void main(String[] args) throws Exception {
        launch();
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Student Management System [AVIRAL GUPTA 20BCE0481"+ "]");
        mainscene(primaryStage);
    }

    public class Login {

        public VBox showdb() throws SQLException, ClassNotFoundException {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/java_link", "root", "01493250215");
            Statement stmt = con.createStatement();

            String sql = "SELECT * FROM students ";
            VBox vb = new VBox();
            
            ResultSet rs = stmt.executeQuery(sql);
            javafx.scene.text.Font font1 = new javafx.scene.text.Font("Calibri", 20);
            HBox hb1 = new HBox();
            hb1.setSpacing(80);

            Label la1 = new Label("REG_NO");
            Label la2 = new Label("NAME");
            Label la3 = new Label("PASSWORD");
            Label la4 = new Label("GENDER");
            Label la5 = new Label("PROGRAMME");
            Label la6 = new Label("SCHOOL");
            Label la7 = new Label("DATE OF BIRTH");
            Label la8 = new Label("PROG_LANGUAGE");
            la1.setUnderline(true);
            la2.setUnderline(true);
            la3.setUnderline(true);
            la4.setUnderline(true);
            la5.setUnderline(true);
            la6.setUnderline(true);
            la7.setUnderline(true);
            la8.setUnderline(true);
            
            la1.setFont(font1);
            la2.setFont(font1);
            la3.setFont(font1);
            la4.setFont(font1);
            la5.setFont(font1);
            la6.setFont(font1);
            la7.setFont(font1);
            la8.setFont(font1);
            hb1.getChildren().addAll(la1, la2, la3, la4, la5, la6, la7, la8);
            vb.getChildren().add(hb1);
            while (rs.next()) {

                HBox hb = new HBox();
                hb.setSpacing(50);
                javafx.scene.text.Font font = new javafx.scene.text.Font("Calibri", 15);
                Label l1 = new Label(rs.getString(1)+"\t  ");
                Label l2 = new Label(rs.getString(2)+"\t\t");
                Label l3 = new Label(rs.getString(3)+"\t\t\t  ");
                Label l4 = new Label(rs.getString(4)+"\t\t\t   ");
                Label l5 = new Label(rs.getString(5)+"\t\t\t     ");
                Label l6 = new Label(rs.getString(6)+"\t\t\t");
                Label l7 = new Label("" + rs.getDate(7)+"\t\t\t  ");
                Label l8 = new Label(rs.getString(8));
                l1.setFont(font);
                l2.setFont(font);
                l3.setFont(font);
                l4.setFont(font);
                l5.setFont(font);
                l6.setFont(font);
                l7.setFont(font);
                l8.setFont(font);
                hb.getChildren().addAll(l1, l2, l3, l4, l5, l6, l7, l8);
                vb.getChildren().add(hb);
            }

            return vb;
        }

        public void insertdb(String reg_no, String name, String password, String gender, String program, String school, String date, String lang) {

            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                Connection con = DriverManager.getConnection(
                        "jdbc:mysql://localhost:3306/java_link", "root", "01493250215");

                Statement stmt;
                stmt = con.createStatement();

                PreparedStatement stmt2 = con.prepareStatement("insert into students values(?,?,?,?,?,?,?,?)");
                stmt2.setString(1, reg_no);//1 specifies the first parameter in the query  
                stmt2.setString(2, name);
                stmt2.setString(3, password);
                stmt2.setString(4, gender);
                stmt2.setString(5, program);
                stmt2.setString(6, school);
                stmt2.setString(7, date);
                stmt2.setString(8, lang);

                stmt2.executeUpdate();

                con.close();
            } catch (Exception e) {
                System.out.println(e);
            }

        }

        public void updatedb(String up, String field, String reg_no) {
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                Connection con = DriverManager.getConnection(
                        "jdbc:mysql://localhost:3306/java_link", "root", "01493250215");

                Statement stmt;
                stmt = con.createStatement();

                PreparedStatement stmt2 = con.prepareStatement("update students set " + field + "=? where reg_no=?");

                stmt2.setString(1, up);
                stmt2.setString(2, reg_no);

                stmt2.executeUpdate();

                con.close();
            } catch (Exception e) {
                System.out.println(e);
            }

        }

        public void deletedb(String reg_no) {
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                Connection con = DriverManager.getConnection(
                        "jdbc:mysql://localhost:3306/java_link", "root", "01493250215");

                Statement stmt;
                stmt = con.createStatement();

                PreparedStatement stmt2 = con.prepareStatement("delete from students where reg_no=(?)");
                stmt2.setString(1, reg_no);
                stmt2.executeUpdate();

                con.close();
            } catch (Exception e) {
                System.out.println(e);
            }

        }
    }

    public void mainscene(Stage stage) {
        GridPane gridPane = new GridPane();
        gridPane.setVgap(20);
        gridPane.setHgap(20);
        gridPane.setAlignment(Pos.CENTER);

        javafx.scene.text.Font font = new javafx.scene.text.Font("Calibri", 30);
        javafx.scene.text.Font font1 = new javafx.scene.text.Font("Calibri",45);
        
        Label l = new Label("STUDENT MANAGEMENT SYSTEM");
        l.setUnderline(true);
        l.setFont(font1);
        Button add = new Button("ADD   ");
        
        add.setOnAction(e -> {
            try {
                add_Scene(stage);
            } catch (SQLException ex) {
                Logger.getLogger(java_theory_da.class.getName()).log(Level.SEVERE, null, ex);
            }
        });

        Button delete = new Button("DELETE");
        delete.setOnAction(e -> {
            try {
                delete_Scene(stage);
            } catch (SQLException | ClassNotFoundException ex) {
                Logger.getLogger(java_theory_da.class.getName()).log(Level.SEVERE, null, ex);
            }
        });

        Button show = new Button("SHOW");
        show.setOnAction(e -> {
            try {
                show_Scene(stage);
            } catch (SQLException | ClassNotFoundException ex) {
                Logger.getLogger(java_theory_da.class.getName()).log(Level.SEVERE, null, ex);
            }
        });

        Button update = new Button("UPDATE");
        update.setOnAction(e -> {
            try {
                update_Scene(stage);
            } catch (SQLException | ClassNotFoundException ex) {
                Logger.getLogger(java_theory_da.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        add.setFont(font);
        show.setFont(font);
        delete.setFont(font);
        update.setFont(font);
        
        gridPane.add(l, 0, 0);
        GridPane p = new GridPane();
        p.add(add, 1, 1);
        p.add(delete, 2, 1);
        p.add(show, 1, 2);
        p.add(update, 2, 2);
        p.setVgap(20);
        p.setHgap(20);
        p.setAlignment(Pos.CENTER);
        gridPane.add(p, 0, 1);
        
        Scene mainscene = new Scene(gridPane, 1500, 750);
        stage.setScene(mainscene);
        stage.show();
    }

    public void show_Scene(Stage stage) throws SQLException, ClassNotFoundException {
        GridPane gridPane = new GridPane();
        gridPane.setVgap(20);
        gridPane.setHgap(20);
        gridPane.setAlignment(Pos.CENTER);
        Login obj = new Login();
        Button back = new Button("Back");
        back.setOnAction(e -> {
            mainscene(stage);
        });

        gridPane.add(obj.showdb(), 0, 0);
        gridPane.add(back, 1, 1);
        Scene show_scene = new Scene(gridPane, 1500, 750);
        stage.setScene(show_scene);
        stage.show();
    }

    public void update_Scene(Stage stage) throws SQLException, ClassNotFoundException {
        GridPane gridPane = new GridPane();
        gridPane.setVgap(20);
        gridPane.setHgap(20);
        gridPane.setAlignment(Pos.CENTER);
        javafx.scene.text.Font font1 = new javafx.scene.text.Font("Calibri", 20);
        Label lb1 = new Label("Enter Registeration No.");
        lb1.setFont(font1);
        Label lb2 = new Label("Select Field to be updated  ");
        lb2.setFont(font1);
        ComboBox<String> cb = new ComboBox<>();
        cb.getItems().addAll("Reg_No", "Name", "Password", "Gender", "Programme", "School", "Date_Of_Birth", "Programming_Language");
        
        TextField tf = new TextField();
        tf.setFont(font1);
        gridPane.add(lb1, 0, 0);
        gridPane.add(lb2, 0, 1);
        gridPane.add(cb, 1, 1);
        gridPane.add(tf, 1, 0);

        cb.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                TextField tf1 = new TextField();
                tf1.setFont(font1);
                Label l = new Label(cb.getValue());
                l.setFont(font1);
                gridPane.add(l, 0, 2);
                gridPane.add(tf1, 1, 2);

                Button update = new Button("UPDATE");
                update.setFont(font1);
                gridPane.add(update, 1, 3);
                Login obj = new Login();
                update.setOnAction(eh -> {

                    obj.updatedb(tf1.getText(), cb.getValue(), tf.getText());
                    try {
                        Scene3(stage);
                    } catch (SQLException ex) {
                        Logger.getLogger(java_theory_da.class.getName()).log(Level.SEVERE, null, ex);
                    }
                });

            }
        });

        Scene update_scene = new Scene(gridPane, 1500, 750);
        stage.setScene(update_scene);
        stage.show();
    }

    public void delete_Scene(Stage stage) throws SQLException, ClassNotFoundException {
        GridPane gridPane = new GridPane();
        gridPane.setVgap(20);
        gridPane.setHgap(20);
        gridPane.setAlignment(Pos.CENTER);
        javafx.scene.text.Font font1 = new javafx.scene.text.Font("Calibri", 20);
        Label lb1 = new Label("Enter Reg_No. to be deleted ");
        lb1.setFont(font1);
        
        TextField tf = new TextField();
        tf.setFont(font1);
        Button delete = new Button("DELETE");
        delete.setFont(font1);
        Login obj = new Login();
        delete.setOnAction(e -> {
            obj.deletedb(tf.getText());
            try {
                Scene3(stage);
            } catch (SQLException ex) {
                Logger.getLogger(java_theory_da.class.getName()).log(Level.SEVERE, null, ex);
            }
        });

        gridPane.add(lb1, 0, 0);
        gridPane.add(tf, 0, 1);
        gridPane.add(delete, 0, 2);
        Scene delete_scene = new Scene(gridPane, 1500, 750);
        stage.setScene(delete_scene);
        stage.show();
    }

    public void add_Scene(Stage stage) throws SQLException {

        GridPane gridPane = new GridPane();
        gridPane.setVgap(20);
        gridPane.setHgap(20);
        gridPane.setAlignment(Pos.CENTER);
        javafx.scene.text.Font font1 = new javafx.scene.text.Font("Calibri", 20);
        Label lb1 = new Label("Reg_No.  ");
        Label lb2 = new Label("Name     ");
        Label lb3 = new Label("Password ");
        Label lb4 = new Label("Gender   ");
        Label lb5 = new Label("Programme");
        Label lb6 = new Label("School   ");
        Label lb7 = new Label("Date Of Birth");
        Label lb8 = new Label("Programming Languages");
        TextField tf1 = new TextField();
        TextField tf2 = new TextField();
        PasswordField tf3 = new PasswordField();
        
        
        lb1.setFont(font1);
        lb2.setFont(font1);
        lb3.setFont(font1);
        lb4.setFont(font1);
        lb5.setFont(font1);
        lb6.setFont(font1);
        lb7.setFont(font1);
        lb8.setFont(font1);

        DatePicker dp = new DatePicker();
        
        ComboBox<String> cb = new ComboBox<>();
        cb.getItems().addAll("B.Tech", "M.Tech", "UG", "PG", "MBA");

        VBox vb1 = new VBox();
        RadioButton rb1 = new RadioButton("SCOPE");
        RadioButton rb2 = new RadioButton("SITE");
        RadioButton rb3 = new RadioButton("SENSE");

        ToggleGroup group = new ToggleGroup();
        rb1.setToggleGroup(group);
        rb2.setToggleGroup(group);
        rb3.setToggleGroup(group);

        vb1.getChildren().addAll(rb1, rb2, rb3);

        VBox vb2 = new VBox();

        CheckBox cb1 = new CheckBox("JAVA");
        CheckBox cb2 = new CheckBox("PYTHON");
        CheckBox cb3 = new CheckBox("C/C++");
        vb2.getChildren().addAll(cb1, cb2, cb3);

        VBox vb3 = new VBox();
        RadioButton rb_1 = new RadioButton("Male");
        RadioButton rb_2 = new RadioButton("Female");
        RadioButton rb_3 = new RadioButton("Others");
        ToggleGroup group2 = new ToggleGroup();
        rb1.setToggleGroup(group2);
        rb2.setToggleGroup(group2);
        rb3.setToggleGroup(group2);
        vb3.getChildren().addAll(rb_1, rb_2, rb_3);

        Button add = new Button("ADD");
        Label l = new Label("STUDENT'S INFORMATION");
        l.setUnderline(true);
        javafx.scene.text.Font font = new javafx.scene.text.Font("Calibri", 30);
        l.setFont(font);
        gridPane.add(l, 2, 0);
        gridPane.add(lb1, 1, 1);
        gridPane.add(lb2, 1, 2);
        gridPane.add(lb3, 1, 3);
        gridPane.add(lb4, 1, 4);
        gridPane.add(lb5, 1, 5);
        gridPane.add(lb6, 1, 6);
        gridPane.add(lb7, 1, 7);
        gridPane.add(lb8, 1, 8);

        gridPane.add(tf1, 2, 1);
        gridPane.add(tf2, 2, 2);
        gridPane.add(tf3, 2, 3);
        gridPane.add(vb3, 2, 4);
        gridPane.add(cb, 2, 5);
        gridPane.add(vb1, 2, 6);
        gridPane.add(dp, 2, 7);
        gridPane.add(vb2, 2, 8);

        gridPane.add(add, 2, 9);
        add.setFont(font1);
        add.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent e) {
                int status;
                Login obj = new Login();
                String prog_lang = "";
                if (cb1.isSelected()) {
                    prog_lang += "JAVA, ";
                }
                if (cb2.isSelected()) {
                    prog_lang += "PYTHON, ";
                }
                if (cb3.isSelected()) {
                    prog_lang += "C/C++, ";
                }

                String prog = "";
                if (rb1.isSelected()) {
                    prog += "SCOPE";
                } else if (rb2.isSelected()) {
                    prog += "SITE  ";
                } else if (rb3.isSelected()) {
                    prog += "SENSE";
                }

                String gend = "";
                if (rb_1.isSelected()) {
                    gend += "MALE";
                } else if (rb_2.isSelected()) {
                    gend += "FEMALE";
                } else if (rb_3.isSelected()) {
                    gend += "OTHERS";
                }

                try {

                    obj.insertdb(tf1.getText(), tf2.getText(), tf3.getText(), gend, cb.getValue(), prog, "" + dp.getValue(), prog_lang);
                    Scene3(stage);

                } catch (SQLException e1) {

                    e1.printStackTrace();
                }

            }
        });

        Scene scene0 = new Scene(gridPane, 1500, 750);
        stage.setScene(scene0);
        stage.show();
    }

    public void Scene3(Stage stage) throws SQLException {
        VBox vbox = new VBox();
        
        vbox.setAlignment(Pos.CENTER);
        Label lblmessage = new Label("DONE");
        javafx.scene.text.Font font1 = new javafx.scene.text.Font("Calibri", 20);
        Button btnback = new Button("Back");
        lblmessage.setFont(font1);
        btnback.setFont(font1);
        
        vbox.getChildren().add(lblmessage);
        vbox.getChildren().add(btnback);
        
        btnback.setOnAction((e) -> {
            mainscene(stage);
        });

        Scene scene2 = new Scene(vbox, 1500, 750);
        stage.setScene(scene2);
        stage.show();

    }

}
