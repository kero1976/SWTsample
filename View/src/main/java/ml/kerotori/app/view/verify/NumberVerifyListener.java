package ml.kerotori.app.view.verify;

import java.math.BigDecimal;

import org.eclipse.swt.events.VerifyEvent;
import org.eclipse.swt.events.VerifyListener;
import org.eclipse.swt.widgets.Text;

public class NumberVerifyListener implements VerifyListener {

	@Override
	public void verifyText(VerifyEvent e) {
		//final String oldS = txtNo.getText();
		final String oldS = ((Text) e.widget).getText();
		final String newS = oldS.substring(0, e.start) + e.text + oldS.substring(e.end);

		try {
			BigDecimal bd = new BigDecimal(newS);
			// value is decimal
			// Test value range
		} catch (final NumberFormatException numberFormatException) {
			// value is not decimal
			e.doit = false;
		}
	}
}