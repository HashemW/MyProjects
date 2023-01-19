import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JCheckBox;
import java.awt.BorderLayout;
import javax.swing.JTable;
import java.awt.GridLayout;
import javax.swing.JRadioButton;
import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;

import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.GridBagConstraints;

import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JScrollPane;
import javax.swing.border.EtchedBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import java.awt.Color;
import javax.swing.AbstractAction;
import java.awt.event.ActionEvent;
import javax.swing.Action;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.beans.PropertyVetoException;
import java.util.ArrayList;

import javax.swing.border.TitledBorder;
import javax.swing.JTabbedPane;
import java.awt.FlowLayout;
import javax.swing.JScrollBar;
import javax.swing.JList;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JDesktopPane;
import java.awt.event.ActionListener;

public class GuiBuilder {

	private JFrame frame;
	private JTextField name;
	private JTextField numChores;
	private ArrayList<Choreperson> list = new ArrayList<>();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GuiBuilder window = new GuiBuilder();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public GuiBuilder() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 640, 386);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(9, 20, 587, 279);
		frame.getContentPane().add(tabbedPane);

		JPanel panel = new JPanel();
		tabbedPane.addTab("List Adder/Remover", null, panel, null);
		panel.setBorder(new TitledBorder(null, "Editor", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setLayout(null);

		JRadioButton SunPMCheck = new JRadioButton("");
		SunPMCheck.setBounds(295, 157, 17, 16);
		panel.add(SunPMCheck);

		JLabel lblNewLabel_4 = new JLabel("Name:");
		lblNewLabel_4.setBounds(17, 47, 89, 31);
		panel.add(lblNewLabel_4);
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 12));

		numChores = new JTextField();
		numChores.setBounds(83, 142, 27, 30);
		panel.add(numChores);
		numChores.setColumns(10);

		name = new JTextField();
		name.setBounds(17, 82, 241, 35);
		panel.add(name);
		name.setColumns(10);

		JRadioButton MonAMCheck = new JRadioButton("");
		MonAMCheck.setBounds(344, 82, 17, 16);
		panel.add(MonAMCheck);

		JRadioButton FriPMCheck = new JRadioButton("");
		FriPMCheck.setBounds(507, 158, 17, 16);
		panel.add(FriPMCheck);

		JRadioButton MonPMCheck = new JRadioButton("");
		MonPMCheck.setBounds(344, 157, 17, 16);
		panel.add(MonPMCheck);

		JRadioButton FormerMecCheck = new JRadioButton("");
		FormerMecCheck.setBounds(182, 146, 103, 21);
		panel.add(FormerMecCheck);

		JLabel lblNewLabel_3_1 = new JLabel("FriAM");
		lblNewLabel_3_1.setBounds(502, 65, 45, 13);
		panel.add(lblNewLabel_3_1);
		lblNewLabel_3_1.setFont(new Font("Tahoma", Font.PLAIN, 8));

		JRadioButton TuePMCheck = new JRadioButton("");
		TuePMCheck.setBounds(388, 158, 17, 16);
		panel.add(TuePMCheck);

		JRadioButton ThuAMCheck = new JRadioButton("");
		ThuAMCheck.setBounds(469, 83, 17, 16);
		panel.add(ThuAMCheck);

		JLabel lblNewLabel_2_1 = new JLabel("WedPM");
		lblNewLabel_2_1.setBounds(420, 140, 45, 13);
		panel.add(lblNewLabel_2_1);
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.PLAIN, 8));

		JLabel lblNewLabel_1_1 = new JLabel("TuePM");
		lblNewLabel_1_1.setBounds(379, 140, 45, 13);
		panel.add(lblNewLabel_1_1);
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 8));

		JLabel lblNewLabel_3 = new JLabel("ThuAM");
		lblNewLabel_3.setBounds(461, 65, 45, 13);
		panel.add(lblNewLabel_3);
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 8));

		JRadioButton ThuPMCheck = new JRadioButton("");
		ThuPMCheck.setBounds(469, 158, 17, 16);
		panel.add(ThuPMCheck);

		JRadioButton WedAMCheck = new JRadioButton("");
		WedAMCheck.setBounds(430, 82, 17, 16);
		panel.add(WedAMCheck);

		JLabel lblTuepm = new JLabel("MonPM");
		lblTuepm.setBounds(336, 140, 45, 13);
		panel.add(lblTuepm);
		lblTuepm.setFont(new Font("Tahoma", Font.PLAIN, 8));

		JLabel lblNewLabel_3_3_1 = new JLabel("SatPM");
		lblNewLabel_3_3_1.setBounds(536, 140, 45, 13);
		panel.add(lblNewLabel_3_3_1);
		lblNewLabel_3_3_1.setFont(new Font("Tahoma", Font.PLAIN, 8));

		JRadioButton SatPMCheck = new JRadioButton("");
		SatPMCheck.setBounds(543, 158, 17, 16);
		panel.add(SatPMCheck);

		JLabel lblNewLabel_1 = new JLabel("TueAM");
		lblNewLabel_1.setBounds(379, 65, 45, 13);
		panel.add(lblNewLabel_1);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 8));

		JLabel lblNewLabel_7 = new JLabel("Which Choretimes is he/she available?");
		lblNewLabel_7.setBounds(292, 15, 258, 40);
		panel.add(lblNewLabel_7);
		lblNewLabel_7.setFont(new Font("Tahoma", Font.PLAIN, 12));

		JRadioButton WedPMCheck = new JRadioButton("");
		WedPMCheck.setBounds(430, 159, 17, 16);
		panel.add(WedPMCheck);

		JLabel lblNewLabel_3_2 = new JLabel("SunAM");
		lblNewLabel_3_2.setBounds(292, 65, 45, 13);
		panel.add(lblNewLabel_3_2);
		lblNewLabel_3_2.setFont(new Font("Tahoma", Font.PLAIN, 8));

		JRadioButton FriAMCheck = new JRadioButton("");
		FriAMCheck.setBounds(505, 83, 17, 16);
		panel.add(FriAMCheck);

		JLabel lblNewLabel_3_3 = new JLabel("SatAM");
		lblNewLabel_3_3.setBounds(536, 65, 45, 13);
		panel.add(lblNewLabel_3_3);
		lblNewLabel_3_3.setFont(new Font("Tahoma", Font.PLAIN, 8));

		JLabel lblNewLabel_6 = new JLabel("Former MEC?");
		lblNewLabel_6.setBounds(116, 140, 77, 34);
		panel.add(lblNewLabel_6);
		lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 11));

		JRadioButton TueAMCheck = new JRadioButton("");
		TueAMCheck.setBounds(388, 83, 17, 16);
		panel.add(TueAMCheck);

		JLabel lblNewLabel_3_4 = new JLabel("ThuPM");
		lblNewLabel_3_4.setBounds(461, 140, 45, 13);
		panel.add(lblNewLabel_3_4);
		lblNewLabel_3_4.setFont(new Font("Tahoma", Font.PLAIN, 8));

		JRadioButton SunAMCheck = new JRadioButton("");
		SunAMCheck.setBounds(295, 82, 17, 16);
		panel.add(SunAMCheck);

		JLabel lblNewLabel_2 = new JLabel("WedAM");
		lblNewLabel_2.setBounds(420, 65, 45, 13);
		panel.add(lblNewLabel_2);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 8));

		JRadioButton SatAMCheck = new JRadioButton("");
		SatAMCheck.setBounds(542, 84, 17, 16);
		panel.add(SatAMCheck);

		JLabel lblNewLabel_3_2_1 = new JLabel("SunPM");
		lblNewLabel_3_2_1.setBounds(292, 140, 45, 13);
		panel.add(lblNewLabel_3_2_1);
		lblNewLabel_3_2_1.setFont(new Font("Tahoma", Font.PLAIN, 8));

		JLabel lblNewLabel = new JLabel("MonAM");
		lblNewLabel.setBounds(336, 65, 45, 13);
		panel.add(lblNewLabel);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 8));

		JLabel lblNewLabel_5 = new JLabel("Chore Count: ");
		lblNewLabel_5.setBounds(6, 139, 75, 34);
		panel.add(lblNewLabel_5);
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 11));

		JLabel lblNewLabel_3_1_1 = new JLabel("FriPM");
		lblNewLabel_3_1_1.setBounds(502, 140, 45, 13);
		panel.add(lblNewLabel_3_1_1);
		lblNewLabel_3_1_1.setFont(new Font("Tahoma", Font.PLAIN, 8));

		JPanel List = new JPanel();
		tabbedPane.addTab("List", null, List, null);
		List.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 582, 252);
		List.add(scrollPane);

		JPanel panel_1 = new JPanel();
		scrollPane.setViewportView(panel_1);
		panel_1.setLayout(new BorderLayout(0, 0));

		JLabel lblNewLabel_8 = new JLabel("List of Names");
		lblNewLabel_8.setFont(new Font("Tahoma", Font.PLAIN, 22));
		panel_1.add(lblNewLabel_8, BorderLayout.NORTH);

		DefaultListModel model = new DefaultListModel();
		JList names = new JList(model);
		names.setFont(new Font("Tahoma", Font.PLAIN, 9));
		panel_1.add(names, BorderLayout.CENTER);

		JPanel Schedule = new JPanel();
		tabbedPane.addTab("Schedule", null, Schedule, null);
		Schedule.setLayout(null);

		JLabel SunAM = new JLabel("SunAM");
		SunAM.setBounds(8, 3, 532, 15);
		Schedule.add(SunAM);

		JLabel SunPM = new JLabel("SunPM");
		SunPM.setBounds(8, 19, 532, 15);
		Schedule.add(SunPM);

		JLabel MonAM = new JLabel("MonAM");
		MonAM.setBounds(8, 35, 532, 15);
		Schedule.add(MonAM);

		JLabel MonPM = new JLabel("MonPM");
		MonPM.setBounds(8, 51, 532, 15);
		Schedule.add(MonPM);

		JLabel TueAM = new JLabel("TueAM");
		TueAM.setBounds(7, 67, 532, 15);
		Schedule.add(TueAM);

		JLabel TuePM = new JLabel("TuePM");
		TuePM.setBounds(7, 83, 532, 15);
		Schedule.add(TuePM);

		JLabel WedAM = new JLabel("WedAM");
		WedAM.setBounds(7, 99, 532, 15);
		Schedule.add(WedAM);

		JLabel WedPM = new JLabel("WedPM");
		WedPM.setBounds(7, 115, 532, 15);
		Schedule.add(WedPM);

		JLabel ThuAM = new JLabel("ThuAM");
		ThuAM.setBounds(7, 129, 532, 15);
		Schedule.add(ThuAM);

		JLabel ThuPM = new JLabel("ThuPM");
		ThuPM.setBounds(7, 145, 532, 15);
		Schedule.add(ThuPM);

		JLabel FriAM = new JLabel("FriAM");
		FriAM.setBounds(7, 161, 532, 15);
		Schedule.add(FriAM);

		JLabel FriPM = new JLabel("FriPM");
		FriPM.setBounds(7, 177, 532, 15);
		Schedule.add(FriPM);

		JLabel SatPM = new JLabel("SatPM");
		SatPM.setBounds(6, 209, 532, 15);
		Schedule.add(SatPM);

		JLabel SatAM = new JLabel("SatAM");
		SatAM.setBounds(6, 193, 532, 15);
		Schedule.add(SatAM);

		JButton btnNewButton = new JButton("Add To List");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (!(numChores.getText().equals("")) && (!(name.getText().equals("")))) {
					Choreperson newPerson = new Choreperson(name.getText(), FormerMecCheck.isSelected(),
							new boolean[14], Integer.parseInt(numChores.getText()));
					StringBuffer schedule = new StringBuffer("");
					if (SunAMCheck.isSelected()) {
						newPerson.setAvailability(0);
						schedule.append("SunAM ");
						SunAMCheck.setSelected(false);
					}
					if (SunPMCheck.isSelected()) {
						newPerson.setAvailability(1);
						schedule.append("SunPM ");
						SunPMCheck.setSelected(false);
					}
					if (MonAMCheck.isSelected()) {
						newPerson.setAvailability(2);
						schedule.append("MonAM ");
						MonAMCheck.setSelected(false);
					}
					if (MonPMCheck.isSelected()) {
						newPerson.setAvailability(3);
						schedule.append("MonPM ");
						MonPMCheck.setSelected(false);
					}
					if (TueAMCheck.isSelected()) {
						newPerson.setAvailability(4);
						schedule.append("TueAM ");
						TueAMCheck.setSelected(false);
					}
					if (TuePMCheck.isSelected()) {
						newPerson.setAvailability(5);
						schedule.append("TuePM ");
						TuePMCheck.setSelected(false);
					}
					if (WedAMCheck.isSelected()) {
						newPerson.setAvailability(6);
						schedule.append("WedAM ");
						WedAMCheck.setSelected(false);
					}
					if (WedPMCheck.isSelected()) {
						newPerson.setAvailability(7);
						schedule.append("WedPM ");
						WedPMCheck.setSelected(false);
					}
					if (ThuAMCheck.isSelected()) {
						newPerson.setAvailability(8);
						schedule.append("ThuAM ");
						ThuAMCheck.setSelected(false);
					}
					if (ThuPMCheck.isSelected()) {
						newPerson.setAvailability(9);
						schedule.append("ThuPM ");
						ThuPMCheck.setSelected(false);
					}
					if (FriAMCheck.isSelected()) {
						newPerson.setAvailability(10);
						schedule.append("FriAM ");
						FriAMCheck.setSelected(false);
					}
					if (FriPMCheck.isSelected()) {
						newPerson.setAvailability(11);
						schedule.append("FriPM ");
						FriPMCheck.setSelected(false);
					}
					if (SatAMCheck.isSelected()) {
						newPerson.setAvailability(12);
						schedule.append("SatAM ");
						SatAMCheck.setSelected(false);
					}
					if (SatPMCheck.isSelected()) {
						newPerson.setAvailability(13);
						schedule.append("SatPM ");
						SatPMCheck.setSelected(false);
					}
					list.add(newPerson);
					model.addElement(name.getText() + ": Chore Count - " + numChores.getText() + ", Former MEC - "
							+ FormerMecCheck.isSelected());
					names.setModel(model);
					model.addElement("Availability: " + schedule.toString());
					names.setModel(model);
					name.setText("");
					numChores.setText("");
					FormerMecCheck.setSelected(false);
				}
			}
		});
		btnNewButton.setBounds(17, 190, 148, 52);
		panel.add(btnNewButton);
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 18));

		JButton remover = new JButton("Remove ");
		remover.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				/*
				 * To remove a name we create a stringbuffer, we will iterate through the list
				 * names to find the correct name and remove it, and then we will iterate
				 * through the model to remove the name from the gui list. we append the full
				 * string to a stringbuffer and then we cut the string buffer to the name
				 * length, and then compare it to the original name to see if we are at the
				 * right place.
				 */
				StringBuffer cutModel = new StringBuffer("");
				for (int i = 0; i < list.size(); i++) {
					if (list.get(i).getName().equals(name.getText())) {
						list.remove(i);
						for (int j = 0; j < model.size(); j++) {
							// we do this so we know we are at a name list entry, what if
							// a person's name is "availability"?
							if (j % 2 == 0) {
								// appending and cutting the stringbuffer
								cutModel.append(model.get(j));
								cutModel.delete(name.getText().length(), cutModel.length());
								// if we are at the right place.
								if (cutModel.toString().equals(name.getText())) {
									model.removeElement(model.get(j));
									// also remove their availability schedule.
									model.removeElement(model.get(j));
									names.setModel(model);
									// reset string buffer
								}
								cutModel.delete(0, cutModel.length());
							}
						}
					}
				}

				name.setText("");
			}
		});
		remover.setFont(new Font("Tahoma", Font.PLAIN, 18));
		remover.setBounds(215, 190, 122, 52);
		panel.add(remover);
		JButton Organize = new JButton("Organize");
		Organize.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
					ArrayList<Choreperson> copList = new ArrayList<>();
					for (int i = 0; i < list.size(); i++) {
						copList.add(new Choreperson(list.get(i)));
					}
					StringBuffer[] schedule = new StringBuffer[14];
					for (int i = 0; i < 14; i++) {
						if (i == 0) {
							schedule[i] = new StringBuffer("Sunday AM: ");
						} else if (i == 1) {
							schedule[i] = new StringBuffer("Sunday PM: ");
						} else if (i == 2) {
							schedule[i] = new StringBuffer("Monday AM: ");
						} else if (i == 3) {
							schedule[i] = new StringBuffer("Monday PM: ");
						} else if (i == 4) {
							schedule[i] = new StringBuffer("Tuesday AM: ");
						} else if (i == 5) {
							schedule[i] = new StringBuffer("Tuesday PM: ");
						} else if (i == 6) {
							schedule[i] = new StringBuffer("Wednesday AM: ");
						} else if (i == 7) {
							schedule[i] = new StringBuffer("Wednesday PM: ");
						} else if (i == 8) {
							schedule[i] = new StringBuffer("Thursday AM: ");
						} else if (i == 9) {
							schedule[i] = new StringBuffer("Thursday PM: ");
						} else if (i == 10) {
							schedule[i] = new StringBuffer("Friday AM: ");
						} else if (i == 11) {
							schedule[i] = new StringBuffer("Friday PM: ");
						} else if (i == 12) {
							schedule[i] = new StringBuffer("Saturday AM: ");
						} else if (i == 13) {
							schedule[i] = new StringBuffer("Saturday PM: ");
						}
					}
					organize(copList, schedule);
					SunAM.setText(schedule[0].toString());
					SunPM.setText(schedule[1].toString());
					MonAM.setText(schedule[2].toString());
					MonPM.setText(schedule[3].toString());
					TueAM.setText(schedule[4].toString());
					TuePM.setText(schedule[5].toString());
					WedAM.setText(schedule[6].toString());
					WedPM.setText(schedule[7].toString());
					ThuAM.setText(schedule[8].toString());
					ThuPM.setText(schedule[9].toString());
					FriAM.setText(schedule[10].toString());
					FriPM.setText(schedule[11].toString());
					SatAM.setText(schedule[12].toString());
					SatPM.setText(schedule[13].toString());
			}
		});
		Organize.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		panel_1.add(Organize, BorderLayout.EAST);

		JScrollBar scrollBar = new JScrollBar();
		scrollBar.setBounds(565, 0, 17, 252);
		List.add(scrollBar);
	}

	/*
	 * This method sets availability of choreperson's chores to true (default value
	 * is false).
	 */
	public static void printEveryone(ArrayList<Choreperson> people) {
		for (int i = 0; i < people.size(); i++) {
			System.out.println(people.get(i).toString());
		}
	}

	/*
	 * The aids method.
	 */
	public static void organize(ArrayList<Choreperson> listOfChorePeople, StringBuffer[] schedule) {
		/*
		 * I first create a new arraylist which will store the former mec members in a
		 * list because they will get priority on the schedule first (We need them
		 * spread out as much as possible to teach the new members, if we organize them
		 * first, the odds of them being spread out more is more likely, I assume so
		 * idfk I haven't proven it yet)
		 */
		ArrayList<Choreperson> formerMecList = new ArrayList<>();
		// StringBuffer[] schedule = new StringBuffer[14];
		for (int i = 0; i < 14; i++) {
			if (i == 0) {
				schedule[i] = new StringBuffer("Sunday AM: ");
			} else if (i == 1) {
				schedule[i] = new StringBuffer("Sunday PM: ");
			} else if (i == 2) {
				schedule[i] = new StringBuffer("Monday AM: ");
			} else if (i == 3) {
				schedule[i] = new StringBuffer("Monday PM: ");
			} else if (i == 4) {
				schedule[i] = new StringBuffer("Tuesday AM: ");
			} else if (i == 5) {
				schedule[i] = new StringBuffer("Tuesday PM: ");
			} else if (i == 6) {
				schedule[i] = new StringBuffer("Wednesday AM: ");
			} else if (i == 7) {
				schedule[i] = new StringBuffer("Wednesday PM: ");
			} else if (i == 8) {
				schedule[i] = new StringBuffer("Thursday AM: ");
			} else if (i == 9) {
				schedule[i] = new StringBuffer("Thursday PM: ");
			} else if (i == 10) {
				schedule[i] = new StringBuffer("Friday AM: ");
			} else if (i == 11) {
				schedule[i] = new StringBuffer("Friday PM: ");
			} else if (i == 12) {
				schedule[i] = new StringBuffer("Saturday AM: ");
			} else if (i == 13) {
				schedule[i] = new StringBuffer("Saturday PM: ");
			}
		}
		/*
		 * Standard for loop, iterates through parameter list and adds all people former
		 * mec into the new formerMecList
		 */
		for (int i = 0; i < listOfChorePeople.size(); i++) {
			if (listOfChorePeople.get(i).getIsMec()) {
				formerMecList.add(listOfChorePeople.get(i));
				// We remove the mec members from the original list to
				// make organization of the original parameter list easier
				// after we finish the mec members
				listOfChorePeople.remove(i);
				i--;
			}
		}
		ArrayList<ArrayList<Choreperson>> scheduleList = new ArrayList<>();
		for (int i = 0; i < 14; i++) {
			ArrayList<Choreperson> x = new ArrayList<>();
			scheduleList.add(x);
		}
		setSchedule(formerMecList, schedule, scheduleList, false);
		setSchedule(listOfChorePeople, schedule, scheduleList, true);
		postOptimizations(scheduleList);
		addToStringBuffer(schedule, scheduleList);
		for (int i = 0; i < 14; i++) {
			System.out.println(schedule[i]);
		}
	}

	/*
	 * This will take the list given and organize it by adding it into the string
	 * schedule, you might ask why do we use an array? This is because we have a
	 * separate string for each part of the day (ie sunday am or pm), then we will
	 * concatenate all of this in the end.
	 */
	public static void setSchedule(ArrayList<Choreperson> listOfPeople, StringBuffer[] schedule,
			ArrayList<ArrayList<Choreperson>> scheduleList, boolean newMembers) {
		/*
		 * This tolerance array will allow us to know the chores which have the least
		 * amount of people available to do it, thus, those are what are prioritized.
		 * Unfortunately this will lead us to O(n^2) performance, this is because we
		 * iterate through the people, and then the individuals availability...a
		 * necessary sacrifice :( (well technically not O(n^2) but rather
		 * O(listofPeoplelength*individualavailability)
		 */
		int[] tolerance = new int[14];
		/*
		 * The numPeopleOnChore array will allow us to further optimize the output of
		 * the schedule as we can check the amount of people on chore.
		 */
		int[] numPeopleOnChore = new int[14];
		for (int i = 0; i < listOfPeople.size(); i++) {
			for (int j = 0; j < listOfPeople.get(i).getAvailabilty().length; j++) {
				if (listOfPeople.get(i).getAvailabiltyForChore(j)) {
					tolerance[j]++;
				}
			}
		}
		/*
		 * We need the max available per one chore to iterate to that amount in the
		 * forthcoming loops.
		 */
		int maxAvailablePerChore = 0;
		for (int i = 0; i < 14; i++) {
			if (tolerance[i] > maxAvailablePerChore) {
				maxAvailablePerChore = tolerance[i];
			}
		}
		/*
		 * We alter the tolerance here if we are considering new members rather than
		 * former mec members because when organizing the new members, we need to know
		 * how many people are already on chore that were set in the schedule in the
		 * first round of former mec organization, so we update the tolerance as
		 * necessary.
		 */
		if (newMembers == true) {
			for (int i = 0; i < 14; i++) {
				tolerance[i] += scheduleList.get(i).size();
			}
		}

		/*
		 * The outer loop first starts us off by iterating through to find the least
		 * amount of chores that can be covered, then we go through the tolerance to
		 * find which place to fill first, then, we add the first we find which is
		 * available in that tolerance.
		 */
		for (int i = 1; i <= maxAvailablePerChore; i++) {
			for (int j = 0; j < tolerance.length; j++) {
				if (tolerance[j] == i) {
					for (int k = 0; k < listOfPeople.size(); k++) {
						if (listOfPeople.get(k).getAvailabiltyForChore(j)) {
							/*
							 * This schedulList check is to make sure that the same person does not go on
							 * the same shift twice.
							 */
							if (scheduleList.get(j).contains(listOfPeople.get(k)) != true) {
								// schedule[j].append(listOfPeople.get(k).getName() + ", ");
								scheduleList.get(j).add(listOfPeople.get(k));
								if (listOfPeople.get(k).getChoreCount() == 1) {
									listOfPeople.remove(listOfPeople.get(k));
								} else {
									listOfPeople.get(k).decrementChoreCount();
								}
								tolerance[j] += 2;
								i--;
								break;
							}
						}
					}
				}
			}
		}
	}

	/*
	 * This method is simply supposed to do a couple more optimizations,make the
	 * schedule more spread out, etc. THIS IS A RECURSIVE FUNCTION!!!!
	 */
	public static void postOptimizations(ArrayList<ArrayList<Choreperson>> scheduleList) {
		/*
		 * Here is the gist, we calculate the lowest amount of people on chore and the
		 * highest amount of people on chore. If there is a difference of at least 2, we
		 * check the list of the highest people count and try to move chore people from
		 * that list to a chore with lower people.
		 */
		int lowestChoreCount = 0;
		int highestChoreIndex = 0;
		int highestCount = 0;
		int lowestCount = 200;
		int mecCountLargest = 0;
		int mecCountSmallest = 0;
		for (int i = 0; i < 14; i++) {
			if (scheduleList.get(i).size() > highestCount) {
				highestCount = scheduleList.get(i).size();
				highestChoreIndex = i;
			}
			if (scheduleList.get(i).size() < lowestCount) {
				lowestCount = scheduleList.get(i).size();
				lowestChoreCount = i;
			}
		}
		for (int i = 0; i < scheduleList.get(highestChoreIndex).size(); i++) {
			if (scheduleList.get(highestChoreIndex).get(i).getIsMec()) {
				mecCountLargest++;
			}
		}
		for (int i = 0; i < scheduleList.get(lowestChoreCount).size(); i++) {
			if (scheduleList.get(lowestChoreCount).get(i).getIsMec()) {
				mecCountSmallest++;
			}
		}
		/*
		 * This is our base case!!!!!!!!! If the lowest people on chore equals the
		 * highest people on chore, then there is no need for further organizaation as
		 * the schedule is spread out well, also, if there is only a difference of one
		 * between the lowest and the highest, that is a bias I am willing to take, so,
		 * its fine.
		 */
		if (lowestChoreCount == highestChoreIndex || (highestChoreIndex - 1) == lowestChoreCount) {
			return;
		}
		/*
		 * Now, we cut optimization in cases.
		 */
		// Case 1: Complete freedom, at least one mec in smallest, and at least 2 in
		// largest
		if (mecCountSmallest >= 1 && mecCountLargest >= 2) {
			for (int i = 0; i < 14; i++) {
				/*
				 * Why do we do this? Good question. What if we have more than one chore with
				 * this large number?
				 */
				if (scheduleList.get(i).size() == highestCount) {
					for (int j = 0; j < highestCount; j++) {
						if (scheduleList.get(i).get(j).getAvailabiltyForChore(lowestChoreCount)
								&& scheduleList.get(lowestChoreCount).contains(scheduleList.get(i).get(j)) == false) {
							scheduleList.get(lowestChoreCount).add(scheduleList.get(i).get(j));
							scheduleList.get(i).remove(j);
							postOptimizations(scheduleList);
							return;
						}
					}
				}
			}
			/*
			 * Case 2: If we have less than two mec members on the largest chore, here we do
			 * not move the mec member from the larger chore.
			 */
		} else if (mecCountSmallest > 0 && mecCountLargest < 2) {
			for (int i = 0; i < 14; i++) {
				if (scheduleList.get(i).size() == highestCount) {
					for (int j = 0; j < highestCount; j++) {
						if (scheduleList.get(i).get(j).getAvailabiltyForChore(lowestChoreCount)
								&& scheduleList.get(i).get(j).getIsMec() == false
								&& scheduleList.get(lowestChoreCount).contains(scheduleList.get(i).get(j)) == false) {
							scheduleList.get(lowestChoreCount).add(scheduleList.get(i).get(j));
							scheduleList.get(i).remove(j);
							postOptimizations(scheduleList);
							return;
						}
					}
				}
			}
			/*
			 * Case 3: If we have no mec members in the lowest chore, and have more than 1
			 * mec member on the highest chore, then we prioritise moving mec members
			 */
		} else if (mecCountSmallest == 0 && mecCountLargest > 1) {
			for (int i = 0; i < 14; i++) {
				if (scheduleList.get(i).size() == highestCount) {
					for (int j = 0; j < highestCount; j++) {
						if (scheduleList.get(i).get(j).getAvailabiltyForChore(lowestChoreCount)
								&& scheduleList.get(i).get(j).getIsMec() == true
								&& scheduleList.get(lowestChoreCount).contains(scheduleList.get(i).get(j)) == false) {
							scheduleList.get(lowestChoreCount).add(scheduleList.get(i).get(j));
							scheduleList.get(i).remove(j);
							postOptimizations(scheduleList);
							return;
						}
					}
				}
			}
			/*
			 * Case 4: If we have no mec members in the lowest chore, and only one mec
			 * member in the highest chore, we are kind of fucked, so we just return and
			 * allow the user to have the headache :)
			 */
		} else {
			return;
		}

	}

	/*
	 * This method is the final appendation of the entire schedule
	 */
	public static void addToStringBuffer(StringBuffer[] schedule, ArrayList<ArrayList<Choreperson>> scheduleList) {
		for (int i = 0; i < 14; i++) {
			for (int j = 0; j < scheduleList.get(i).size(); j++) {
				schedule[i].append(scheduleList.get(i).get(j).getName() + ", ");
			}
		}
	}
}
