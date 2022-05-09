package com.day14;

import java.awt.FlowLayout;
import javax.swing.JDialog;
import javax.swing.JFrame;

public class Dialog_2 extends JDialog {
	String title = null; //전변에 저장된다.

	public void initDisplay() {
		this.setTitle(title);
		this.setSize(300, 400);
		this.setVisible(true);
	}

	public void set(String title) {
		this.title = title;
	}
}