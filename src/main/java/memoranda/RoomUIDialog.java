package src.main.java.memoranda;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Objects;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SpinnerDateModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingConstants;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import main.java.memoranda.CurrentProject;
import main.java.memoranda.date.CalendarDate;
import main.java.memoranda.util.Local;

import javax.swing.JCheckBox;

public class RoomUIDialog extends JDialog { // Room ----- Room

	// CLASS VARIABLES
	public boolean CANCELLED = true;
	boolean ignoreStartChanged = false;
	boolean ignoreEndChanged = false;
	CalendarDate startDateMin = CurrentProject.get().getStartDate();
	CalendarDate startDateMax = CurrentProject.get().getEndDate();
	CalendarDate endDateMin = startDateMin;
	CalendarDate endDateMax = startDateMax;
	String[] roomID = { Local.getString("Room #1"), Local.getString("Room #2"),
			Local.getString("Room #3"), Local.getString("Room #4") };
	String[] roomVisibility = { Local.getString("Public"), Local.getString("Private") };

	// PANELS
	JPanel mPanel = new JPanel(new BorderLayout());
	JPanel areaPanel = new JPanel(new BorderLayout());
	JPanel buttonsPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
	JPanel dialogTitlePanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
	JPanel trainerIDPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
	JPanel jPanelProgress = new JPanel(new FlowLayout(FlowLayout.RIGHT));

	JPanel endDatePanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
	JPanel visibilityPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
	JPanel roomIDPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
	JPanel startDatePanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
	JPanel emptyPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
	JPanel jPanel2 = new JPanel(new GridLayout(3, 2));
	JPanel jPanel1 = new JPanel(new GridBagLayout());

	// FRAMES
	CalendarFrame startCalFrame = new CalendarFrame();
	CalendarFrame endCalFrame = new CalendarFrame();

	// BUTTONS
	JButton cancelB = new JButton();
	JButton submitB = new JButton();
	JButton setStartDateButton = new JButton();
	JButton setEndDateB = new JButton();
	// JButton setNotifB = new JButton();

	// BORDERS
	Border border1, border2, border3, border4, border5;

	// LABELS
	JLabel header = new JLabel();
	JLabel endDateLabel = new JLabel();
	JLabel startDateLabel = new JLabel();
	JLabel roomIDLabel = new JLabel();
	JLabel visibilityLabel = new JLabel();

	JLabel trainerIDLabel = new JLabel();
	JLabel classDescriptionLabel = new JLabel();
	JLabel jLabelProgress = new JLabel();

	// TEXT FIELDS
	JTextField classNameField = new JTextField();
	JTextField trainerIDField = new JTextField();
	JTextArea descriptionField = new JTextArea();

	// PANES
	JScrollPane descriptionScrollPane = new JScrollPane(descriptionField);

	// OTHER
	JSpinner startDate = new JSpinner(new SpinnerDateModel(new Date(), null, null, Calendar.DAY_OF_WEEK));;
	JSpinner endDate = new JSpinner(new SpinnerDateModel(new Date(), null, null, Calendar.DAY_OF_WEEK));
	JSpinner progress = new JSpinner(new SpinnerNumberModel(0, 0, 100, 5));
	JComboBox roomIDCB = new JComboBox(roomID);
	JComboBox roomVisCB = new JComboBox(roomVisibility);
	JCheckBox chkEndDate = new JCheckBox();

	public RoomUIDialog(Frame frame, String title) {
		super(frame, title, true);
		try {
			jbInit();
			pack();
		} catch (Exception ex) {
			new ExceptionDialog(ex);
		}
	}

	void jbInit() throws Exception {

		this.setResizable(false);
		this.setSize(new Dimension(430, 300));

		// Borders
		// +-------------------------------------------------------------+
		border1 = BorderFactory.createEmptyBorder(5, 5, 5, 5);
		border2 = BorderFactory.createEtchedBorder(Color.white, new Color(142, 142, 142));
		border3 = new TitledBorder(BorderFactory.createEmptyBorder(0, 0, 10, 0),
				Local.getString("Class Name"), TitledBorder.LEFT, TitledBorder.BELOW_TOP);
		border4 = BorderFactory.createEmptyBorder(0, 5, 0, 5);
		border5 = BorderFactory.createEtchedBorder(Color.white, new Color(178, 178, 178));
		this.getRootPane().setDefaultButton(submitB);
		mPanel.setBorder(border1);
		areaPanel.setBorder(border2);
		dialogTitlePanel.setBackground(Color.WHITE);
		dialogTitlePanel.setBorder(border4);

		// Header

		header.setFont(new java.awt.Font("Dialog", 0, 20));
		header.setForeground(new Color(0, 0, 124));
		header.setText(Local.getString("Create a new class"));
		header.setIcon(new ImageIcon(Objects.requireNonNull(TaskDialog.class.getResource(
				"/ui/icons/create_class_icon.png"))));

		// Grid Bag Layout for Class Name and Description

		GridBagLayout gbLayout = (GridBagLayout) jPanel1.getLayout();
		jPanel1.setBorder(border3);

		// Class Name

		classNameField.setBorder(border5);
		classNameField.setPreferredSize(new Dimension(375, 24));
		GridBagConstraints gbCon = new GridBagConstraints();
		gbCon.gridwidth = GridBagConstraints.REMAINDER;
		gbCon.weighty = 1;
		gbLayout.setConstraints(classNameField, gbCon);

		// Class Description

		// Label
		classDescriptionLabel.setMaximumSize(new Dimension(100, 16));
		classDescriptionLabel.setMinimumSize(new Dimension(60, 16));
		classDescriptionLabel.setText(Local.getString("Class Description (optional)"));
		gbCon = new GridBagConstraints();
		gbCon.gridwidth = GridBagConstraints.REMAINDER;
		gbCon.weighty = 1;
		gbCon.anchor = GridBagConstraints.WEST;
		gbLayout.setConstraints(classDescriptionLabel, gbCon);

		// Description box
		descriptionField.setBorder(border5);
		descriptionField.setPreferredSize(new Dimension(375, 387));
		descriptionField.setLineWrap(true);
		descriptionField.setWrapStyleWord(true);
		gbCon = new GridBagConstraints();
		gbCon.gridwidth = GridBagConstraints.REMAINDER;
		gbCon.weighty = 3;
		descriptionScrollPane.setPreferredSize(new Dimension(375, 96));
		gbLayout.setConstraints(descriptionScrollPane, gbCon);

		// Start Date Section

		startDate.setBorder(border5);
		startDate.setPreferredSize(new Dimension(80, 24));
		SimpleDateFormat sdf = new SimpleDateFormat();
		sdf = (SimpleDateFormat) DateFormat.getDateInstance(DateFormat.SHORT);
		startDate.setEditor(new JSpinner.DateEditor(startDate, sdf.toPattern()));

		startDateLabel.setText(Local.getString("Start date"));
		startDateLabel.setMinimumSize(new Dimension(60, 16));
		startDateLabel.setMaximumSize(new Dimension(100, 16));
		setStartDateButton.setMinimumSize(new Dimension(24, 24));
		setStartDateButton.setPreferredSize(new Dimension(24, 24));
		setStartDateButton.setText("");
		setStartDateButton
				.setIcon(new ImageIcon(Objects.requireNonNull(AppFrame.class.getResource("/ui/icons/calendar.png"))));

		setStartDateButton.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actionPerformed(e);
			}
		});
		startDate.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				SpinnerDateModel sdm = new SpinnerDateModel((Date) startDate.getModel().getValue(), null, null,
						Calendar.DAY_OF_WEEK);
				startDate.setModel(sdm);

				if (ignoreStartChanged)
					return;
				ignoreStartChanged = true;
				Date sd = (Date) startDate.getModel().getValue();
				Date ed = (Date) endDate.getModel().getValue();
				if (sd.after(ed) && chkEndDate.isSelected()) {
					startDate.getModel().setValue(ed);
					sd = ed;
				}
				if ((startDateMax != null) && sd.after(startDateMax.getDate())) {
					startDate.getModel().setValue(startDateMax.getDate());
					sd = startDateMax.getDate();
				}
				if ((startDateMin != null) && sd.before(startDateMin.getDate())) {
					startDate.getModel().setValue(startDateMin.getDate());
					sd = startDateMin.getDate();
				}
				startCalFrame.cal.set(new CalendarDate(sd));
				ignoreStartChanged = false;
			}
		});
		startCalFrame.cal.addSelectionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (ignoreStartChanged)
					return;
				startDate.getModel().setValue(startCalFrame.cal.get().getCalendar().getTime());
			}
		});

		// End Date Section

		chkEndDate.setSelected(false);
		chkEndDate_actionPerformed(null);
		endDateLabel.setMaximumSize(new Dimension(270, 16));
		endDateLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		endDateLabel.setText(Local.getString("End date"));
		endDate.setBorder(border5);
		endDate.setPreferredSize(new Dimension(80, 24));
		endDate.setEditor(new JSpinner.DateEditor(endDate, sdf.toPattern()));
		endDate.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				SpinnerDateModel sdm = new SpinnerDateModel((Date) endDate.getModel().getValue(), null, null,
						Calendar.DAY_OF_WEEK);
				endDate.setModel(sdm);

				if (ignoreEndChanged)
					return;
				ignoreEndChanged = true;
				Date sd = (Date) startDate.getModel().getValue();
				Date ed = (Date) endDate.getModel().getValue();
				if (ed.before(sd)) {
					endDate.getModel().setValue(ed);
					ed = sd;
				}
				if ((endDateMax != null) && ed.after(endDateMax.getDate())) {
					endDate.getModel().setValue(endDateMax.getDate());
					ed = endDateMax.getDate();
				}
				if ((endDateMin != null) && ed.before(endDateMin.getDate())) {
					endDate.getModel().setValue(endDateMin.getDate());
					ed = endDateMin.getDate();
				}
				endCalFrame.cal.set(new CalendarDate(ed));
				ignoreEndChanged = false;
			}
		});
		chkEndDate.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(ActionEvent e) {
				chkEndDate_actionPerformed(e);
			}
		});

		setEndDateB.setMinimumSize(new Dimension(24, 24));
		setEndDateB.setPreferredSize(new Dimension(24, 24));
		setEndDateB.setText("");
		setEndDateB
				.setIcon(new ImageIcon(Objects.requireNonNull(AppFrame.class.getResource("/ui/icons/calendar.png"))));
		setEndDateB.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setEndDateB_actionPerformed(e);
			}
		});
		endCalFrame.cal.addSelectionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (ignoreEndChanged)
					return;
				endDate.getModel().setValue(endCalFrame.cal.get().getCalendar().getTime());
			}
		});

		// Trainer ID Section

		trainerIDLabel.setMaximumSize(new Dimension(100, 16));
		trainerIDLabel.setMinimumSize(new Dimension(60, 16));
		trainerIDLabel.setText(Local.getString("Trainer ID"));
		trainerIDField.setBorder(border5);
		trainerIDField.setPreferredSize(new Dimension(30, 24));

		// Room ID Section

		roomIDLabel.setMaximumSize(new Dimension(100, 16));
		roomIDLabel.setMinimumSize(new Dimension(60, 16));
		roomIDLabel.setText(Local.getString("Room ID"));

		roomIDCB.setFont(new java.awt.Font("Dialog", 0, 12));
		roomIDCB.setSelectedItem(Local.getString("Room #1"));

		// Visibility Section

		visibilityLabel.setMaximumSize(new Dimension(100, 16));
		visibilityLabel.setMinimumSize(new Dimension(60, 16));
		visibilityLabel.setText(Local.getString("Visibility"));
		roomVisCB.setFont(new java.awt.Font("Dialog", 0, 12));

		// Cancel Button

		cancelB.setMaximumSize(new Dimension(100, 26));
		cancelB.setMinimumSize(new Dimension(100, 26));
		cancelB.setPreferredSize(new Dimension(100, 26));
		cancelB.setText(Local.getString("Cancel"));
		cancelB.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cancelB_actionPerformed(e);
			}
		});
	}
}
