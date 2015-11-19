package com.raise.core.identity;

public interface IdGenerator {

	public abstract long nextId();
	
	public abstract String nextStrId();

}