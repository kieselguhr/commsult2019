package realsimulator;

public class Main {
	public static void main(String args[]) {
		MainViewer mv = new MainViewer();

		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				mv.createAndShowGUI();
			}
		});
	}
}
