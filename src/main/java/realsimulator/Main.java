package realsimulator;

public class Main {
	public static void main(String args[]) {
		final MainViewer mv = new MainViewer();
		final MainController mc = new MainController(mv);

		mv.setMc(mc);

		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				mv.createAndShowGUI();
			}
		});
		mc.run();
	}
}
