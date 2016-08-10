/**
 */
package PSMDoc.impl;

import PSMDoc.PSMDocPackage;
import PSMDoc.Paragraph;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Paragraph</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link PSMDoc.impl.ParagraphImpl#getParagraphSpacing <em>Paragraph Spacing</em>}</li>
 *   <li>{@link PSMDoc.impl.ParagraphImpl#getLineSpacing <em>Line Spacing</em>}</li>
 *   <li>{@link PSMDoc.impl.ParagraphImpl#getIndent <em>Indent</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ParagraphImpl extends TextContainerImpl implements Paragraph {
	/**
	 * The default value of the '{@link #getParagraphSpacing() <em>Paragraph Spacing</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getParagraphSpacing()
	 * @generated
	 * @ordered
	 */
	protected static final double PARAGRAPH_SPACING_EDEFAULT = 0.0;

	/**
	 * The cached value of the '{@link #getParagraphSpacing() <em>Paragraph Spacing</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getParagraphSpacing()
	 * @generated
	 * @ordered
	 */
	protected double paragraphSpacing = PARAGRAPH_SPACING_EDEFAULT;

	/**
	 * The default value of the '{@link #getLineSpacing() <em>Line Spacing</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLineSpacing()
	 * @generated
	 * @ordered
	 */
	protected static final double LINE_SPACING_EDEFAULT = 0.0;

	/**
	 * The cached value of the '{@link #getLineSpacing() <em>Line Spacing</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLineSpacing()
	 * @generated
	 * @ordered
	 */
	protected double lineSpacing = LINE_SPACING_EDEFAULT;

	/**
	 * The default value of the '{@link #getIndent() <em>Indent</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIndent()
	 * @generated
	 * @ordered
	 */
	protected static final double INDENT_EDEFAULT = 0.0;

	/**
	 * The cached value of the '{@link #getIndent() <em>Indent</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIndent()
	 * @generated
	 * @ordered
	 */
	protected double indent = INDENT_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ParagraphImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return PSMDocPackage.Literals.PARAGRAPH;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getParagraphSpacing() {
		return paragraphSpacing;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setParagraphSpacing(double newParagraphSpacing) {
		double oldParagraphSpacing = paragraphSpacing;
		paragraphSpacing = newParagraphSpacing;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PSMDocPackage.PARAGRAPH__PARAGRAPH_SPACING, oldParagraphSpacing, paragraphSpacing));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getLineSpacing() {
		return lineSpacing;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLineSpacing(double newLineSpacing) {
		double oldLineSpacing = lineSpacing;
		lineSpacing = newLineSpacing;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PSMDocPackage.PARAGRAPH__LINE_SPACING, oldLineSpacing, lineSpacing));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getIndent() {
		return indent;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIndent(double newIndent) {
		double oldIndent = indent;
		indent = newIndent;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PSMDocPackage.PARAGRAPH__INDENT, oldIndent, indent));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case PSMDocPackage.PARAGRAPH__PARAGRAPH_SPACING:
				return getParagraphSpacing();
			case PSMDocPackage.PARAGRAPH__LINE_SPACING:
				return getLineSpacing();
			case PSMDocPackage.PARAGRAPH__INDENT:
				return getIndent();
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
			case PSMDocPackage.PARAGRAPH__PARAGRAPH_SPACING:
				setParagraphSpacing((Double)newValue);
				return;
			case PSMDocPackage.PARAGRAPH__LINE_SPACING:
				setLineSpacing((Double)newValue);
				return;
			case PSMDocPackage.PARAGRAPH__INDENT:
				setIndent((Double)newValue);
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
			case PSMDocPackage.PARAGRAPH__PARAGRAPH_SPACING:
				setParagraphSpacing(PARAGRAPH_SPACING_EDEFAULT);
				return;
			case PSMDocPackage.PARAGRAPH__LINE_SPACING:
				setLineSpacing(LINE_SPACING_EDEFAULT);
				return;
			case PSMDocPackage.PARAGRAPH__INDENT:
				setIndent(INDENT_EDEFAULT);
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
			case PSMDocPackage.PARAGRAPH__PARAGRAPH_SPACING:
				return paragraphSpacing != PARAGRAPH_SPACING_EDEFAULT;
			case PSMDocPackage.PARAGRAPH__LINE_SPACING:
				return lineSpacing != LINE_SPACING_EDEFAULT;
			case PSMDocPackage.PARAGRAPH__INDENT:
				return indent != INDENT_EDEFAULT;
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
		result.append(" (paragraphSpacing: ");
		result.append(paragraphSpacing);
		result.append(", lineSpacing: ");
		result.append(lineSpacing);
		result.append(", indent: ");
		result.append(indent);
		result.append(')');
		return result.toString();
	}

} //ParagraphImpl
