/**
 */
package benchmarkdp.datagenerator.model.PSMLibre.impl;

import benchmarkdp.datagenerator.model.PSMLibre.Color;
import benchmarkdp.datagenerator.model.PSMLibre.FontFamily;
import benchmarkdp.datagenerator.model.PSMLibre.PSMLibrePackage;
import benchmarkdp.datagenerator.model.PSMLibre.TextContainer;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Text Container</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link benchmarkdp.datagenerator.model.PSMLibre.impl.TextContainerImpl#getFontFamily <em>Font Family</em>}</li>
 *   <li>{@link benchmarkdp.datagenerator.model.PSMLibre.impl.TextContainerImpl#getFontColor <em>Font Color</em>}</li>
 * </ul>
 *
 * @generated
 */
public abstract class TextContainerImpl extends ElementImpl implements TextContainer {
	/**
	 * The default value of the '{@link #getFontFamily() <em>Font Family</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFontFamily()
	 * @generated
	 * @ordered
	 */
	protected static final FontFamily FONT_FAMILY_EDEFAULT = FontFamily.LIBERATIONMONO;

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
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TextContainerImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return PSMLibrePackage.Literals.TEXT_CONTAINER;
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
			eNotify(new ENotificationImpl(this, Notification.SET, PSMLibrePackage.TEXT_CONTAINER__FONT_FAMILY, oldFontFamily, fontFamily));
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
			eNotify(new ENotificationImpl(this, Notification.SET, PSMLibrePackage.TEXT_CONTAINER__FONT_COLOR, oldFontColor, fontColor));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case PSMLibrePackage.TEXT_CONTAINER__FONT_FAMILY:
				return getFontFamily();
			case PSMLibrePackage.TEXT_CONTAINER__FONT_COLOR:
				return getFontColor();
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
			case PSMLibrePackage.TEXT_CONTAINER__FONT_FAMILY:
				setFontFamily((FontFamily)newValue);
				return;
			case PSMLibrePackage.TEXT_CONTAINER__FONT_COLOR:
				setFontColor((Color)newValue);
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
			case PSMLibrePackage.TEXT_CONTAINER__FONT_FAMILY:
				setFontFamily(FONT_FAMILY_EDEFAULT);
				return;
			case PSMLibrePackage.TEXT_CONTAINER__FONT_COLOR:
				setFontColor(FONT_COLOR_EDEFAULT);
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
			case PSMLibrePackage.TEXT_CONTAINER__FONT_FAMILY:
				return fontFamily != FONT_FAMILY_EDEFAULT;
			case PSMLibrePackage.TEXT_CONTAINER__FONT_COLOR:
				return fontColor != FONT_COLOR_EDEFAULT;
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
		result.append(')');
		return result.toString();
	}

} //TextContainerImpl
