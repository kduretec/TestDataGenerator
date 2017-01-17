/**
 */
package benchmarkdp.datagenerator.model.PSMLibre.impl;

import benchmarkdp.datagenerator.model.PSMLibre.Color;
import benchmarkdp.datagenerator.model.PSMLibre.FontFamily;
import benchmarkdp.datagenerator.model.PSMLibre.PSMLibrePackage;
import benchmarkdp.datagenerator.model.PSMLibre.SimpleText;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Simple Text</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link benchmarkdp.datagenerator.model.PSMLibre.impl.SimpleTextImpl#getFontFamily <em>Font Family</em>}</li>
 *   <li>{@link benchmarkdp.datagenerator.model.PSMLibre.impl.SimpleTextImpl#getFontColor <em>Font Color</em>}</li>
 *   <li>{@link benchmarkdp.datagenerator.model.PSMLibre.impl.SimpleTextImpl#getFontBackground <em>Font Background</em>}</li>
 *   <li>{@link benchmarkdp.datagenerator.model.PSMLibre.impl.SimpleTextImpl#getFontSize <em>Font Size</em>}</li>
 * </ul>
 *
 * @generated
 */
public class SimpleTextImpl extends TextImpl implements SimpleText {
	/**
	 * The default value of the '{@link #getFontFamily() <em>Font Family</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFontFamily()
	 * @generated
	 * @ordered
	 */
	protected static final FontFamily FONT_FAMILY_EDEFAULT = FontFamily.ARIAL;
	/**
	 * The cached value of the '{@link #getFontFamily() <em>Font Family</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFontFamily()
	 * @generated
	 * @ordered
	 */
	protected FontFamily fontFamily = FONT_FAMILY_EDEFAULT;
	/**
	 * The default value of the '{@link #getFontColor() <em>Font Color</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFontColor()
	 * @generated
	 * @ordered
	 */
	protected static final Color FONT_COLOR_EDEFAULT = Color.BLACK;
	/**
	 * The cached value of the '{@link #getFontColor() <em>Font Color</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFontColor()
	 * @generated
	 * @ordered
	 */
	protected Color fontColor = FONT_COLOR_EDEFAULT;
	/**
	 * The default value of the '{@link #getFontBackground() <em>Font Background</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFontBackground()
	 * @generated
	 * @ordered
	 */
	protected static final Color FONT_BACKGROUND_EDEFAULT = Color.WHITE;
	/**
	 * The cached value of the '{@link #getFontBackground() <em>Font Background</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFontBackground()
	 * @generated
	 * @ordered
	 */
	protected Color fontBackground = FONT_BACKGROUND_EDEFAULT;
	/**
	 * The default value of the '{@link #getFontSize() <em>Font Size</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFontSize()
	 * @generated
	 * @ordered
	 */
	protected static final int FONT_SIZE_EDEFAULT = 10;
	/**
	 * The cached value of the '{@link #getFontSize() <em>Font Size</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFontSize()
	 * @generated
	 * @ordered
	 */
	protected int fontSize = FONT_SIZE_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SimpleTextImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return PSMLibrePackage.Literals.SIMPLE_TEXT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FontFamily getFontFamily() {
		return fontFamily;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFontFamily(FontFamily newFontFamily) {
		FontFamily oldFontFamily = fontFamily;
		fontFamily = newFontFamily == null ? FONT_FAMILY_EDEFAULT : newFontFamily;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PSMLibrePackage.SIMPLE_TEXT__FONT_FAMILY, oldFontFamily, fontFamily));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Color getFontColor() {
		return fontColor;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFontColor(Color newFontColor) {
		Color oldFontColor = fontColor;
		fontColor = newFontColor == null ? FONT_COLOR_EDEFAULT : newFontColor;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PSMLibrePackage.SIMPLE_TEXT__FONT_COLOR, oldFontColor, fontColor));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Color getFontBackground() {
		return fontBackground;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFontBackground(Color newFontBackground) {
		Color oldFontBackground = fontBackground;
		fontBackground = newFontBackground == null ? FONT_BACKGROUND_EDEFAULT : newFontBackground;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PSMLibrePackage.SIMPLE_TEXT__FONT_BACKGROUND, oldFontBackground, fontBackground));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getFontSize() {
		return fontSize;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFontSize(int newFontSize) {
		int oldFontSize = fontSize;
		fontSize = newFontSize;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PSMLibrePackage.SIMPLE_TEXT__FONT_SIZE, oldFontSize, fontSize));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case PSMLibrePackage.SIMPLE_TEXT__FONT_FAMILY:
				return getFontFamily();
			case PSMLibrePackage.SIMPLE_TEXT__FONT_COLOR:
				return getFontColor();
			case PSMLibrePackage.SIMPLE_TEXT__FONT_BACKGROUND:
				return getFontBackground();
			case PSMLibrePackage.SIMPLE_TEXT__FONT_SIZE:
				return getFontSize();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case PSMLibrePackage.SIMPLE_TEXT__FONT_FAMILY:
				setFontFamily((FontFamily)newValue);
				return;
			case PSMLibrePackage.SIMPLE_TEXT__FONT_COLOR:
				setFontColor((Color)newValue);
				return;
			case PSMLibrePackage.SIMPLE_TEXT__FONT_BACKGROUND:
				setFontBackground((Color)newValue);
				return;
			case PSMLibrePackage.SIMPLE_TEXT__FONT_SIZE:
				setFontSize((Integer)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case PSMLibrePackage.SIMPLE_TEXT__FONT_FAMILY:
				setFontFamily(FONT_FAMILY_EDEFAULT);
				return;
			case PSMLibrePackage.SIMPLE_TEXT__FONT_COLOR:
				setFontColor(FONT_COLOR_EDEFAULT);
				return;
			case PSMLibrePackage.SIMPLE_TEXT__FONT_BACKGROUND:
				setFontBackground(FONT_BACKGROUND_EDEFAULT);
				return;
			case PSMLibrePackage.SIMPLE_TEXT__FONT_SIZE:
				setFontSize(FONT_SIZE_EDEFAULT);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case PSMLibrePackage.SIMPLE_TEXT__FONT_FAMILY:
				return fontFamily != FONT_FAMILY_EDEFAULT;
			case PSMLibrePackage.SIMPLE_TEXT__FONT_COLOR:
				return fontColor != FONT_COLOR_EDEFAULT;
			case PSMLibrePackage.SIMPLE_TEXT__FONT_BACKGROUND:
				return fontBackground != FONT_BACKGROUND_EDEFAULT;
			case PSMLibrePackage.SIMPLE_TEXT__FONT_SIZE:
				return fontSize != FONT_SIZE_EDEFAULT;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (fontFamily: ");
		result.append(fontFamily);
		result.append(", fontColor: ");
		result.append(fontColor);
		result.append(", fontBackground: ");
		result.append(fontBackground);
		result.append(", fontSize: ");
		result.append(fontSize);
		result.append(')');
		return result.toString();
	}

} //SimpleTextImpl
