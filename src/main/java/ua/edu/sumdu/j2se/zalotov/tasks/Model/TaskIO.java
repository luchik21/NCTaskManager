package ua.edu.sumdu.j2se.zalotov.tasks.Model;

import com.google.gson.Gson;

import java.io.*;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

public class TaskIO {

    public static void write(AbstractTaskList tasks, OutputStream out) throws IOException {
        try (DataOutputStream outStream = new DataOutputStream(out)) {
            outStream.writeInt(tasks.size());
            for (int i = 0; i < tasks.size(); i++) {
                outStream.writeInt(tasks.getTask(i).getTitle().length());
                outStream.writeUTF(tasks.getTask(i).getTitle());
                outStream.writeBoolean(tasks.getTask(i).isActive());
                outStream.writeInt(tasks.getTask(i).getRepeatInterval());

                if (tasks.getTask(i).isRepeated()) {
                    outStream.writeInt(tasks.getTask(i).getStartTime().getNano());
                    outStream.writeInt(tasks.getTask(i).getEndTime().getNano());
                } else {
                    outStream.writeInt(tasks.getTask(i).getTime().getNano());
                }
            }
        }
    }

    public static void read(AbstractTaskList tasks, InputStream in) throws IOException {
        try (DataInputStream inStream = new DataInputStream(in)) {
            int size = inStream.readInt();
            for (int i = 0; i < size; i++) {
                int titleLength = inStream.readInt();
                String title = inStream.readUTF();
                boolean isActive = inStream.readBoolean();
                int interval = inStream.readInt();

                if (interval > 0) {
                    LocalDateTime start = LocalDateTime.ofEpochSecond(inStream.readInt(), 0, ZoneOffset.UTC);
                    LocalDateTime end = LocalDateTime.ofEpochSecond(inStream.readInt(), 0, ZoneOffset.UTC);

                    Task repeatTask = new Task(title, start, end, interval);
                    repeatTask.setActive(isActive);
                    tasks.add(repeatTask);
                } else {
                    LocalDateTime time = LocalDateTime.ofEpochSecond(inStream.readInt(), 0, ZoneOffset.UTC);

                    Task nonRepeatTask = new Task(title, time);
                    nonRepeatTask.setActive(isActive);
                    tasks.add(nonRepeatTask);
                }
            }
        }
    }

    public static void write(AbstractTaskList tasks, Writer out) throws IOException {
        Gson write = new Gson();
        write.toJson(tasks, out);
        out.flush();
    }

    public static void read(AbstractTaskList tasks, Reader in) {
        Gson read = new Gson();
        AbstractTaskList taskList;
        taskList = read.fromJson(in, tasks.getClass());
        for (Task task : taskList) {
            tasks.add(task);
        }
    }

    public static void writeBinary(AbstractTaskList tasks, File file) {
        try (BufferedWriter buffWriter = new BufferedWriter(new FileWriter(file))) {
            write(tasks, buffWriter);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void readBinary(AbstractTaskList tasks, File file) {
        try (BufferedReader buffReader = new BufferedReader(new FileReader(file))) {
            read(tasks, buffReader);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void writeText(AbstractTaskList tasks, File file) throws IOException {
        try (FileOutputStream outStream = new FileOutputStream(file)) {
            write(tasks, outStream);
        }
    }

    public static void readText(AbstractTaskList tasks, File file) throws IOException {
        try (FileInputStream inStream = new FileInputStream(file)) {
            read(tasks, inStream);
        }
    }

}
