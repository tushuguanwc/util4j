package net.jueb.util4j.tools.taskQueue;

public interface Task {

	/**
	 * 执行动作
	 */
	public void action();
	/**
	 * 任务名字
	 */
	public void getName();
}
