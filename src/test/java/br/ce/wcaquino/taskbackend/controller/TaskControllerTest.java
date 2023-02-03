package br.ce.wcaquino.taskbackend.controller;

import java.time.LocalDate;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import br.ce.wcaquino.taskbackend.model.Task;
import br.ce.wcaquino.taskbackend.repo.TaskRepo;
import br.ce.wcaquino.taskbackend.utils.ValidationException;
import junit.framework.Assert;

public class TaskControllerTest {

	
	@Test
	public void naoDeveSalvarTarefaSemDescricao(){
		Task todo = new Task();
		todo.setDueDate(LocalDate.now());
		TaskController controller = new TaskController();
		try {
			controller.save(todo);
		} catch (ValidationException e) {
			Assert.assertEquals("Fill the task description", e.getMessage());
		}
	}
	
	@Test
	public void naoDeveSalvarTarefaSemData() {
		Task todo = new Task();
		//todo.setDueDate(LocalDate.now());
		todo.setTask("Descricao");
		TaskController controller = new TaskController();
	}
	
	@Test
	public void naoDeveSalvarTarefaComDataPassada() {
		Task todo = new Task();
		todo.setTask("Descricao");
		todo.setDueDate(LocalDate.of(2010, 01, 01));
		TaskController controller = new TaskController();
		try {
			controller.save(todo);
		} catch (ValidationException e) {
			Assert.assertEquals("Due date must not be in past", e.getMessage());
		}
	}
	
	@Test
	public void DeveSalvarTarefaComSucesso() throws ValidationException {
		Task todo = new Task();
		TaskController controller = new TaskController();
		todo.setTask("Descricao");
		todo.setDueDate(LocalDate.now());
	
		
		
	}
}