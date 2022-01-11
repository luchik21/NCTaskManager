package ua.edu.sumdu.j2se.zalotov.tasks.Controller;

import org.apache.log4j.Logger;
import ua.edu.sumdu.j2se.zalotov.tasks.Model.AbstractTaskList;
import ua.edu.sumdu.j2se.zalotov.tasks.Model.TaskIO;
import ua.edu.sumdu.j2se.zalotov.tasks.View.SaveLoadTaskView;
import ua.edu.sumdu.j2se.zalotov.tasks.View.View;
import ua.edu.sumdu.j2se.zalotov.tasks.Model.Error;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class SaveLoadTaskController extends Controller {

    private static final Logger logger = Logger.getLogger(SaveLoadTaskController.class);
    public SaveLoadTaskController(View view, int actionToPerform) {
        super(view, actionToPerform);
    }

    @Override
    public int process(AbstractTaskList taskList) {
        logger.debug("enter to save load task controller");
        int taskChoose = ((SaveLoadTaskView) view).taskChoose();//выбор действия
        File directory = new File("saves");
        directory.mkdir();
        if (taskChoose == 1) {//сохранение
            logger.debug("save tasks to file");
            try {
                String nameFile = ((SaveLoadTaskView) view).fileName(); //имя файла
                TaskIO.write(taskList, new FileWriter("saves/" + nameFile + ".json")); // сохранение в json
                logger.debug("success saved");
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else if (taskChoose == 2) {//загрузка и з файла
            logger.debug("load tasks from file");
            try {
                String nameFile = ((SaveLoadTaskView) view).fileName();   //файл для загрузки сохранений
                TaskIO.read(taskList, new FileReader("saves/" + nameFile + ".json"));
                logger.debug("success loaded");
            } catch (IOException e) {
                System.out.println(Error.FILE_NOT_FOUND);
                return Controller.SAVE_LOAD_ACTION;
            }
        } else if (taskChoose == 3) {//выход в меню
            logger.debug("exit from save load task controller");
            return Controller.MAIN_MENU_ACTION;
        } else {
            System.out.println(Error.WRONG_NUMBER);
            logger.debug("exit from save load task controller");
            return Controller.SAVE_LOAD_ACTION;
        }
        return view.printInfo(taskList);
    }
}
