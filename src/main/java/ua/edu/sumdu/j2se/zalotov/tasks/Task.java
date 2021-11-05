package ua.edu.sumdu.j2se.zalotov.tasks;

public class Task {
    private String title;
    private int start;
    private int time;
    private int end;
    private int interval;
    private boolean isActive;
    private boolean isRepeated;

    public Task(String title, int time) {
        this.title = title;
        this.time = time;
        isRepeated = false;
        if (time < 0) {
            throw new IllegalArgumentException("Time can not be less than 0");
        }
    }

    public Task(String title, int start, int end, int interval) {
        this.title = title;
        this.start = start;
        this.end = end;
        this.interval = interval;
        isRepeated = true;
        if (start < 0 || end < 0) {
            throw new IllegalArgumentException("Time can not be less than 0");
        }
        if (interval < 0) {
            throw new IllegalArgumentException("Interval cant be less than 0");
        }
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getStartTime() {
        if (isRepeated) {
            return start;
        }
        return time;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public int getTime() {
        if (isRepeated) {
            return start;
        }
        return time;
    }

    public void setTime(int time) {
        if (isRepeated()) {
            setRepeated(false);
        }
        this.time = time;
    }

    public void setTime(int start, int end, int interval) {
        if (!isRepeated()) {
            setRepeated(true);
        }
        this.start = start;
        this.end = end;
        this.interval = interval;
    }

    public int getEndTime() {
        if (isRepeated) {
            return end;
        }
        return time;
    }

    public void setEnd(int end) {
        this.end = end;
    }

    public int getInterval() {
        return interval;
    }

    public void setInterval(int interval) {
        this.interval = interval;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public boolean isRepeated() {
        return isRepeated;
    }

    public void setRepeated(boolean repeated) {
        isRepeated = repeated;
    }

    public int getRepeatInterval() {
        if (isRepeated) {
            return interval;
        }
        return 0;
    }

    public int nextTimeAfter(int current) {
        if (isActive()) {
            if (!isRepeated()) {
                if (current < getTime()) {
                    return getTime();
                }
                return -1;
            } else if (isRepeated()) {
                if (current < getStartTime()) {
                    return getStartTime();
                } else if (getStartTime() <= current) {
                    int count = start;
                    while (count <= current) {
                        count += interval;
                    }
                    if (count > getEndTime()) {
                        return -1;
                    }
                    return count;
                }
            }
        }
        return -1;
    }

}
