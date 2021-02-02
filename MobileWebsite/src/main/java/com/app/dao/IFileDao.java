package com.app.dao;

public interface IFileDao {
	public String addFile(byte[] file);
	public byte[] getFile();
}
