/**
 */
package benchmarkdp.documentgenerator.MSWord2007.impl;

import benchmarkdp.documentgenerator.MSWord2007.Document;
import benchmarkdp.documentgenerator.MSWord2007.MSWordPackage;
import benchmarkdp.documentgenerator.MSWord2007.Page;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Document</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link benchmarkdp.documentgenerator.MSWord2007.impl.DocumentImpl#getName <em>Name</em>}</li>
 *   <li>{@link benchmarkdp.documentgenerator.MSWord2007.impl.DocumentImpl#getAuthor <em>Author</em>}</li>
 *   <li>{@link benchmarkdp.documentgenerator.MSWord2007.impl.DocumentImpl#getPages <em>Pages</em>}</li>
 *   <li>{@link benchmarkdp.documentgenerator.MSWord2007.impl.DocumentImpl#getNumColum <em>Num Colum</em>}</li>
 *   <li>{@link benchmarkdp.documentgenerator.MSWord2007.impl.DocumentImpl#getFormat <em>Format</em>}</li>
 *   <li>{@link benchmarkdp.documentgenerator.MSWord2007.impl.DocumentImpl#getFormatCode <em>Format Code</em>}</li>
 * </ul>
 *
 * @generated
 */
public class DocumentImpl extends MinimalEObjectImpl.Container implements Document {
	/**
	 * The default value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected static final String NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected String name = NAME_EDEFAULT;

	/**
	 * The default value of the '{@link #getAuthor() <em>Author</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAuthor()
	 * @generated
	 * @ordered
	 */
	protected static final String AUTHOR_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getAuthor() <em>Author</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAuthor()
	 * @generated
	 * @ordered
	 */
	protected String author = AUTHOR_EDEFAULT;

	/**
	 * The cached value of the '{@link #getPages() <em>Pages</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPages()
	 * @generated
	 * @ordered
	 */
	protected EList<Page> pages;

	/**
	 * The default value of the '{@link #getNumColum() <em>Num Colum</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNumColum()
	 * @generated
	 * @ordered
	 */
	protected static final int NUM_COLUM_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getNumColum() <em>Num Colum</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNumColum()
	 * @generated
	 * @ordered
	 */
	protected int numColum = NUM_COLUM_EDEFAULT;

	/**
	 * The default value of the '{@link #getFormat() <em>Format</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFormat()
	 * @generated
	 * @ordered
	 */
	protected static final String FORMAT_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getFormat() <em>Format</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFormat()
	 * @generated
	 * @ordered
	 */
	protected String format = FORMAT_EDEFAULT;

	/**
	 * The default value of the '{@link #getFormatCode() <em>Format Code</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFormatCode()
	 * @generated
	 * @ordered
	 */
	protected static final String FORMAT_CODE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getFormatCode() <em>Format Code</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFormatCode()
	 * @generated
	 * @ordered
	 */
	protected String formatCode = FORMAT_CODE_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected DocumentImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return MSWordPackage.Literals.DOCUMENT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getName() {
		return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setName(String newName) {
		String oldName = name;
		name = newName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MSWordPackage.DOCUMENT__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getAuthor() {
		return author;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAuthor(String newAuthor) {
		String oldAuthor = author;
		author = newAuthor;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MSWordPackage.DOCUMENT__AUTHOR, oldAuthor, author));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Page> getPages() {
		if (pages == null) {
			pages = new EObjectContainmentEList<Page>(Page.class, this, MSWordPackage.DOCUMENT__PAGES);
		}
		return pages;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getNumColum() {
		return numColum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setNumColum(int newNumColum) {
		int oldNumColum = numColum;
		numColum = newNumColum;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MSWordPackage.DOCUMENT__NUM_COLUM, oldNumColum, numColum));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getFormat() {
		return format;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFormat(String newFormat) {
		String oldFormat = format;
		format = newFormat;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MSWordPackage.DOCUMENT__FORMAT, oldFormat, format));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getFormatCode() {
		return formatCode;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFormatCode(String newFormatCode) {
		String oldFormatCode = formatCode;
		formatCode = newFormatCode;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MSWordPackage.DOCUMENT__FORMAT_CODE, oldFormatCode, formatCode));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case MSWordPackage.DOCUMENT__PAGES:
				return ((InternalEList<?>)getPages()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case MSWordPackage.DOCUMENT__NAME:
				return getName();
			case MSWordPackage.DOCUMENT__AUTHOR:
				return getAuthor();
			case MSWordPackage.DOCUMENT__PAGES:
				return getPages();
			case MSWordPackage.DOCUMENT__NUM_COLUM:
				return getNumColum();
			case MSWordPackage.DOCUMENT__FORMAT:
				return getFormat();
			case MSWordPackage.DOCUMENT__FORMAT_CODE:
				return getFormatCode();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case MSWordPackage.DOCUMENT__NAME:
				setName((String)newValue);
				return;
			case MSWordPackage.DOCUMENT__AUTHOR:
				setAuthor((String)newValue);
				return;
			case MSWordPackage.DOCUMENT__PAGES:
				getPages().clear();
				getPages().addAll((Collection<? extends Page>)newValue);
				return;
			case MSWordPackage.DOCUMENT__NUM_COLUM:
				setNumColum((Integer)newValue);
				return;
			case MSWordPackage.DOCUMENT__FORMAT:
				setFormat((String)newValue);
				return;
			case MSWordPackage.DOCUMENT__FORMAT_CODE:
				setFormatCode((String)newValue);
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
			case MSWordPackage.DOCUMENT__NAME:
				setName(NAME_EDEFAULT);
				return;
			case MSWordPackage.DOCUMENT__AUTHOR:
				setAuthor(AUTHOR_EDEFAULT);
				return;
			case MSWordPackage.DOCUMENT__PAGES:
				getPages().clear();
				return;
			case MSWordPackage.DOCUMENT__NUM_COLUM:
				setNumColum(NUM_COLUM_EDEFAULT);
				return;
			case MSWordPackage.DOCUMENT__FORMAT:
				setFormat(FORMAT_EDEFAULT);
				return;
			case MSWordPackage.DOCUMENT__FORMAT_CODE:
				setFormatCode(FORMAT_CODE_EDEFAULT);
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
			case MSWordPackage.DOCUMENT__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case MSWordPackage.DOCUMENT__AUTHOR:
				return AUTHOR_EDEFAULT == null ? author != null : !AUTHOR_EDEFAULT.equals(author);
			case MSWordPackage.DOCUMENT__PAGES:
				return pages != null && !pages.isEmpty();
			case MSWordPackage.DOCUMENT__NUM_COLUM:
				return numColum != NUM_COLUM_EDEFAULT;
			case MSWordPackage.DOCUMENT__FORMAT:
				return FORMAT_EDEFAULT == null ? format != null : !FORMAT_EDEFAULT.equals(format);
			case MSWordPackage.DOCUMENT__FORMAT_CODE:
				return FORMAT_CODE_EDEFAULT == null ? formatCode != null : !FORMAT_CODE_EDEFAULT.equals(formatCode);
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
		result.append(" (name: ");
		result.append(name);
		result.append(", author: ");
		result.append(author);
		result.append(", numColum: ");
		result.append(numColum);
		result.append(", format: ");
		result.append(format);
		result.append(", formatCode: ");
		result.append(formatCode);
		result.append(')');
		return result.toString();
	}

} //DocumentImpl
