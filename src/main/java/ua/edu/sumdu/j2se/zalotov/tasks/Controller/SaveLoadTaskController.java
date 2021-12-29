package ua.edu.sumdu.j2se.zalotov.tasks.Controller;

import ua.edu.sumdu.j2se.zalotov.tasks.Model.AbstractTaskList;
import ua.edu.sumdu.j2se.zalotov.tasks.Model.TaskIO;
import ua.edu.sumdu.j2se.zalotov.tasks.View.SaveLoadTaskView;
import ua.edu.sumdu.j2se.zalotov.tasks.View.View;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class SaveLoadTaskController extends Controller {

    public SaveLoadTaskController(View view, int actionToPerform) {
        super(view, actionToPerform);
    }

    @Override
    public int process(AbstractTaskList taskList) {
        int taskChoose = ((SaveLoadTaskView) view).taskChoose();
        File directory = new File("saves");
        directory.mkdir();
        if (taskChoose == 1) {
            try {
                String nameFile = ((SaveLoadTaskView) view).fileName(); //имя файла
                TaskIO.write(taskList, new FileWriter("saves/" + nameFile + ".json")); // сохранение в json
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else if (taskChoose == 2) {
            try {
                String nameFile = ((SaveLoadTaskView) view).fileName();   //файл для загрузки сохранений
                TaskIO.read(taskList, new FileReader("saves/" + nameFile + ".json"));
            } catch (IOException e) {
                e.printStackTrace();
                return Controller.SAVE_LOAD_ACTION;
            }
        } else if (taskChoose == 3) {
            return Controller.MAIN_MENU_ACTION;
        } else {
            System.out.println("wrong number");
            return Controller.SAVE_LOAD_ACTION;
        }
        return view.printInfo(taskList);
    }
}
