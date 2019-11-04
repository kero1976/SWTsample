package ml.kerotori.app.view;

import java.util.Date;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.VerifyListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

import ml.kerotori.app.domain.Address;
import ml.kerotori.app.infrastructure.dao.AddressDao;
import ml.kerotori.app.view.verify.NumberVerifyListener;

public class AddressView {

	protected Shell shell;
	private Text txtNo;
	private Text txtName;
	private Text txtAddress1;
	private Text txtAddress2;
	private Text txtBirtyday;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			AddressView window = new AddressView();
			window.open();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Open the window.
	 */
	public void open() {
		Display display = Display.getDefault();
		createContents();
		shell.open();
		shell.layout();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	public static String acceptableChar = "ABCDEFGHIJKLMNOPQRSTUVWXYZ ";

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shell = new Shell();
		shell.setSize(450, 300);
		shell.setText("SWT Application");
		shell.setLayout(new GridLayout(2, false));



		Label lblNo = new Label(shell, SWT.NONE);
		lblNo.setText("No");
		txtNo = new Text(shell, SWT.BORDER);
		txtNo.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));

		VerifyListener numberVertify = new NumberVerifyListener();
		txtNo.addVerifyListener(numberVertify);

		Label label = new Label(shell, SWT.NONE);
		label.setText("名前");
		txtName = new Text(shell, SWT.BORDER);
		txtName.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		txtName.addVerifyListener(numberVertify);

		Label label_1 = new Label(shell, SWT.NONE);
		label_1.setText("住所1");
		txtAddress1 = new Text(shell, SWT.BORDER);
		txtAddress1.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));

		Label label_2 = new Label(shell, SWT.NONE);
		label_2.setText("住所2");
		txtAddress2 = new Text(shell, SWT.BORDER);
		txtAddress2.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));

		Label label_3 = new Label(shell, SWT.NONE);
		label_3.setText("誕生日");
		txtBirtyday = new Text(shell, SWT.BORDER);
		txtBirtyday.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));

		Button btnSave = new Button(shell, SWT.NONE);
		btnSave.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent arg0) {
				try {
					AddressDao dao = new AddressDao();
					Address address = new Address();
					address.setNo(Integer.parseInt(txtNo.getText()));
					address.setName(txtName.getText());
					address.setAddress1(txtAddress1.getText());
					address.setAddress2(txtAddress2.getText());
					address.setBirthday(new Date(txtBirtyday.getText()));
					dao.setAddress(address);
					if(dao.Save()) {
						MessageBox msgBox = new MessageBox(shell, SWT.ICON_INFORMATION | SWT.OK);
						msgBox.setText("MessageBox");
						msgBox.setMessage("登録成功");
						int reply = msgBox.open();
					}else {
						MessageBox msgBox = new MessageBox(shell, SWT.ICON_ERROR | SWT.OK);
						msgBox.setText("MessageBox");
						msgBox.setMessage("登録失敗");
						int reply = msgBox.open();
					}
				}catch(Exception e) {
					MessageBox msgBox = new MessageBox(shell, SWT.ICON_ERROR | SWT.OK);
					msgBox.setText("MessageBox");
					msgBox.setMessage("例外発生");
					int reply = msgBox.open();
				}


			}
		});
		btnSave.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false, false, 2, 1));
		btnSave.setText("登録");

	}

}
