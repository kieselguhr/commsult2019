package abstracts;

import interfaces.IActor;

public abstract class Actor implements IActor {

	public abstract int effectEnvironment(int value);
	public abstract String prepareMessage();
	
}
