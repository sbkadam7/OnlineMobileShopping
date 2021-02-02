package com.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.IFileDao;

@Service
@Transactional
public class StorageFileImp implements IStorageService {
	@Autowired
	private IFileDao dao;
	@Override
	public String addFile(byte[] file) {
		dao.addFile(file);
		return null;
	}

	@Override
	public byte[] getFile() {
		// TODO Auto-generated method stub
		return null;
	}

}
