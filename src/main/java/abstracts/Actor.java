package abstracts;

import interfaces.IActor;

public abstract class Actor implements IActor {

	public abstract int effectEnviroment(int value);
	public abstract String prepareMessage();
	
}
