package dept;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import dept.controller.Controller;
import dept.controller.DeleteController;
import dept.controller.ExitController;
import dept.controller.InsertController;
import dept.controller.SelectByController;
import dept.controller.SelectController;
import dept.controller.UpdateController;


public class Command {

	public Map<Integer, Controller> command; // List와 달리 넣을 위치 지정 가능
	
	public Command() {
		command = new HashMap<>();
		command.put(1, new SelectController());
		command.put(2, new SelectByController());
		command.put(3, new InsertController());
		command.put(4, new UpdateController());
		command.put(5, new DeleteController());
		command.put(6, new ExitController());
		
	}
	

//	public List<Controller> list;

//	public List() {
//		list = new ArrayList<>();	
//		list.add(null);                    // 0부터 시작하므로
//		list.add(new SelectController());
//		list.add(new SelectByController());
//		list.add(new InsertController());
//		list.add(new UpdateController());
//		list.add(new DeleteController());
//		list.add(new ExitController());	
//	}
	
}
