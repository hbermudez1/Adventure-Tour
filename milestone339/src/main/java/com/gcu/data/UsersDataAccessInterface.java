package com.gcu.data;

import java.util.List;

public interface UsersDataAccessInterface<T> {
	public T getUser(int id);
	public T getUserByUsername(String username);
	public List<T> getUsers();
	public int addUser(T newUser);
	public boolean deleteUser(int id);
	public T updateUser(int idToUpdate, T updateUser);
	public T authenticate(String username, String password);
}
