/**
 */
package PSMDoc.impl;

import PSMDoc.Color;
import PSMDoc.FontFamily;
import PSMDoc.PSMDocPackage;
import PSMDoc.SimpleText;

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
 *   <li>{@link PSMDoc.impl.SimpleTextImpl#getSize <em>Size</em>}</li>
 *   <li>{@link PSMDoc.impl.SimpleTextImpl#getColor <em>Color</em>}</li>
 *   <li>{@link PSMDoc.impl.SimpleTextImpl#getBackground <em>Background</em>}</li>
 *   <li>{@link PSMDoc.impl.SimpleTextImpl#getFontFamily <em>Font Family</em>}</li>
 * </ul>
 *
 * @generated
 */
public class SimpleTextImpl extends TextImpl implements SimpleText {
	/**
	 * The default value of the '{@link #getSize() <em>Size</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSize()
	 * @generated
	 * @ordered
	 */
	protected static final int SIZE_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getSize() <em>Size</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSize()
	 * @generated
	 * @ordered
	 */
	protected int size = SIZE_EDEFAULT;

	/**
	 * The default value of the '{@link #getColor() <em>Color</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getColor()
	 * @generated
	 * @ordered
	 */
	protected static final Color COLOR_EDEFAULT = Color.BLACK;

	/**
	 * The cached value of the '{@link #getColor() <em>Color</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getColor()
	 * @generated
	 * @ordered
	 */
	protected Color color = COLOR_EDEFAULT;

	/**
	 * The default value of the '{@link #getBackground() <em>Background</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBackground()
	 * @generated
	 * @ordered
	 */
	protected static final Color BACKGROUND_EDEFAULT = Color.BLACK;

	/**
	 * The cached value of the '{@link #getBackground() <em>Background</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBackground()
	 * @generated
	 * @ordered
	 */
	protected Color background = BACKGROUND_EDEFAULT;

	/**
	 * The default value of the '{@link #getFontFamily() <em>Font Family</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFontFamily()
	 * @generated
	 * @ordered
	 */
	protected static final FontFamily FONT_FAMILY_EDEFAULT = FontFamily.CALIBRI;

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
		return PSMDocPackage.Literals.SIMPLE_TEXT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getSize() {
		return size;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSize(int newSize) {
		int oldSize = size;
		size = newSize;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PSMDocPackage.SIMPLE_TEXT__SIZE, oldSize, size));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Color getColor() {
		return color;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setColor(Color newColor) {
		Color oldColor = color;
		color = newColor == null ? COLOR_EDEFAULT : newColor;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PSMDocPackage.SIMPLE_TEXT__COLOR, oldColor, color));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Color getBackground() {
		return background;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBackground(Color newBackground) {
		Color oldBackground = background;
		background = newBackground == null ? BACKGROUND_EDEFAULT : newBackground;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PSMDocPackage.SIMPLE_TEXT__BACKGROUND, oldBackground, background));
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
			eNotify(new ENotificationImpl(this, Notification.SET, PSMDocPackage.SIMPLE_TEXT__FONT_FAMILY, oldFontFamily, fontFamily));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case PSMDocPackage.SIMPLE_TEXT__SIZE:
				return getSize();
			case PSMDocPackage.SIMPLE_TEXT__COLOR:
				return getColor();
			case PSMDocPackage.SIMPLE_TEXT__BACKGROUND:
				return getBackground();
			case PSMDocPackage.SIMPLE_TEXT__FONT_FAMILY:
				return getFontFamily();
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
			case PSMDocPackage.SIMPLE_TEXT__SIZE:
				setSize((Integer)newValue);
				return;
			case PSMDocPackage.SIMPLE_TEXT__COLOR:
				setColor((Color)newValue);
				return;
			case PSMDocPackage.SIMPLE_TEXT__BACKGROUND:
				setBackground((Color)newValue);
				return;
			case PSMDocPackage.SIMPLE_TEXT__FONT_FAMILY:
				setFontFamily((FontFamily)newValue);
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
			case PSMDocPackage.SIMPLE_TEXT__SIZE:
				setSize(SIZE_EDEFAULT);
				return;
			case PSMDocPackage.SIMPLE_TEXT__COLOR:
				setColor(COLOR_EDEFAULT);
				return;
			case PSMDocPackage.SIMPLE_TEXT__BACKGROUND:
				setBackground(BACKGROUND_EDEFAULT);
				return;
			case PSMDocPackage.SIMPLE_TEXT__FONT_FAMILY:
				setFontFamily(FONT_FAMILY_EDEFAULT);
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
			case PSMDocPackage.SIMPLE_TEXT__SIZE:
				return size != SIZE_EDEFAULT;
			case PSMDocPackage.SIMPLE_TEXT__COLOR:
				return color != COLOR_EDEFAULT;
			case PSMDocPackage.SIMPLE_TEXT__BACKGROUND:
				return background != BACKGROUND_EDEFAULT;
			case PSMDocPackage.SIMPLE_TEXT__FONT_FAMILY:
				return fontFamily != FONT_FAMILY_EDEFAULT;
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
		result.append(" (size: ");
		result.append(size);
		result.append(", color: ");
		result.append(color);
		result.append(", background: ");
		result.append(background);
		result.append(", fontFamily: ");
		result.append(fontFamily);
		result.append(')');
		return result.toString();
	}

} //SimpleTextImpl
