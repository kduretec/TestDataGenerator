/**
 */
package benchmarkdp.datagenerator.model.PSMDoc.impl;

import benchmarkdp.datagenerator.model.PSMDoc.Document;
import benchmarkdp.datagenerator.model.PSMDoc.PSMDocPackage;
import benchmarkdp.datagenerator.model.PSMDoc.Page;

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
 *   <li>{@link benchmarkdp.datagenerator.model.PSMDoc.impl.DocumentImpl#getName <em>Name</em>}</li>
 *   <li>{@link benchmarkdp.datagenerator.model.PSMDoc.impl.DocumentImpl#getAuthor <em>Author</em>}</li>
 *   <li>{@link benchmarkdp.datagenerator.model.PSMDoc.impl.DocumentImpl#getNumColum <em>Num Colum</em>}</li>
 *   <li>{@link benchmarkdp.datagenerator.model.PSMDoc.impl.DocumentImpl#getDocumentFormat <em>Document Format</em>}</li>
 *   <li>{@link benchmarkdp.datagenerator.model.PSMDoc.impl.DocumentImpl#getDocumentFormatCode <em>Document Format Code</em>}</li>
 *   <li>{@link benchmarkdp.datagenerator.model.PSMDoc.impl.DocumentImpl#getPages <em>Pages</em>}</li>
 *   <li>{@link benchmarkdp.datagenerator.model.PSMDoc.impl.DocumentImpl#getDocumentPlatform <em>Document Platform</em>}</li>
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
	 * The default value of the '{@link #getDocumentFormat() <em>Document Format</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDocumentFormat()
	 * @generated
	 * @ordered
	 */
	protected static final String DOCUMENT_FORMAT_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getDocumentFormat() <em>Document Format</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDocumentFormat()
	 * @generated
	 * @ordered
	 */
	protected String documentFormat = DOCUMENT_FORMAT_EDEFAULT;

	/**
	 * The default value of the '{@link #getDocumentFormatCode() <em>Document Format Code</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDocumentFormatCode()
	 * @generated
	 * @ordered
	 */
	protected static final String DOCUMENT_FORMAT_CODE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getDocumentFormatCode() <em>Document Format Code</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDocumentFormatCode()
	 * @generated
	 * @ordered
	 */
	protected String documentFormatCode = DOCUMENT_FORMAT_CODE_EDEFAULT;

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
	 * The default value of the '{@link #getDocumentPlatform() <em>Document Platform</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDocumentPlatform()
	 * @generated
	 * @ordered
	 */
	protected static final String DOCUMENT_PLATFORM_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getDocumentPlatform() <em>Document Platform</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDocumentPlatform()
	 * @generated
	 * @ordered
	 */
	protected String documentPlatform = DOCUMENT_PLATFORM_EDEFAULT;

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
		return PSMDocPackage.Literals.DOCUMENT;
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
			eNotify(new ENotificationImpl(this, Notification.SET, PSMDocPackage.DOCUMENT__NAME, oldName, name));
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
			eNotify(new ENotificationImpl(this, Notification.SET, PSMDocPackage.DOCUMENT__AUTHOR, oldAuthor, author));
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
			eNotify(new ENotificationImpl(this, Notification.SET, PSMDocPackage.DOCUMENT__NUM_COLUM, oldNumColum, numColum));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getDocumentFormat() {
		return documentFormat;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDocumentFormat(String newDocumentFormat) {
		String oldDocumentFormat = documentFormat;
		documentFormat = newDocumentFormat;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PSMDocPackage.DOCUMENT__DOCUMENT_FORMAT, oldDocumentFormat, documentFormat));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getDocumentFormatCode() {
		return documentFormatCode;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDocumentFormatCode(String newDocumentFormatCode) {
		String oldDocumentFormatCode = documentFormatCode;
		documentFormatCode = newDocumentFormatCode;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PSMDocPackage.DOCUMENT__DOCUMENT_FORMAT_CODE, oldDocumentFormatCode, documentFormatCode));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Page> getPages() {
		if (pages == null) {
			pages = new EObjectContainmentEList<Page>(Page.class, this, PSMDocPackage.DOCUMENT__PAGES);
		}
		return pages;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getDocumentPlatform() {
		return documentPlatform;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDocumentPlatform(String newDocumentPlatform) {
		String oldDocumentPlatform = documentPlatform;
		documentPlatform = newDocumentPlatform;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PSMDocPackage.DOCUMENT__DOCUMENT_PLATFORM, oldDocumentPlatform, documentPlatform));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case PSMDocPackage.DOCUMENT__PAGES:
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
			case PSMDocPackage.DOCUMENT__NAME:
				return getName();
			case PSMDocPackage.DOCUMENT__AUTHOR:
				return getAuthor();
			case PSMDocPackage.DOCUMENT__NUM_COLUM:
				return getNumColum();
			case PSMDocPackage.DOCUMENT__DOCUMENT_FORMAT:
				return getDocumentFormat();
			case PSMDocPackage.DOCUMENT__DOCUMENT_FORMAT_CODE:
				return getDocumentFormatCode();
			case PSMDocPackage.DOCUMENT__PAGES:
				return getPages();
			case PSMDocPackage.DOCUMENT__DOCUMENT_PLATFORM:
				return getDocumentPlatform();
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
			case PSMDocPackage.DOCUMENT__NAME:
				setName((String)newValue);
				return;
			case PSMDocPackage.DOCUMENT__AUTHOR:
				setAuthor((String)newValue);
				return;
			case PSMDocPackage.DOCUMENT__NUM_COLUM:
				setNumColum((Integer)newValue);
				return;
			case PSMDocPackage.DOCUMENT__DOCUMENT_FORMAT:
				setDocumentFormat((String)newValue);
				return;
			case PSMDocPackage.DOCUMENT__DOCUMENT_FORMAT_CODE:
				setDocumentFormatCode((String)newValue);
				return;
			case PSMDocPackage.DOCUMENT__PAGES:
				getPages().clear();
				getPages().addAll((Collection<? extends Page>)newValue);
				return;
			case PSMDocPackage.DOCUMENT__DOCUMENT_PLATFORM:
				setDocumentPlatform((String)newValue);
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
			case PSMDocPackage.DOCUMENT__NAME:
				setName(NAME_EDEFAULT);
				return;
			case PSMDocPackage.DOCUMENT__AUTHOR:
				setAuthor(AUTHOR_EDEFAULT);
				return;
			case PSMDocPackage.DOCUMENT__NUM_COLUM:
				setNumColum(NUM_COLUM_EDEFAULT);
				return;
			case PSMDocPackage.DOCUMENT__DOCUMENT_FORMAT:
				setDocumentFormat(DOCUMENT_FORMAT_EDEFAULT);
				return;
			case PSMDocPackage.DOCUMENT__DOCUMENT_FORMAT_CODE:
				setDocumentFormatCode(DOCUMENT_FORMAT_CODE_EDEFAULT);
				return;
			case PSMDocPackage.DOCUMENT__PAGES:
				getPages().clear();
				return;
			case PSMDocPackage.DOCUMENT__DOCUMENT_PLATFORM:
				setDocumentPlatform(DOCUMENT_PLATFORM_EDEFAULT);
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
			case PSMDocPackage.DOCUMENT__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case PSMDocPackage.DOCUMENT__AUTHOR:
				return AUTHOR_EDEFAULT == null ? author != null : !AUTHOR_EDEFAULT.equals(author);
			case PSMDocPackage.DOCUMENT__NUM_COLUM:
				return numColum != NUM_COLUM_EDEFAULT;
			case PSMDocPackage.DOCUMENT__DOCUMENT_FORMAT:
				return DOCUMENT_FORMAT_EDEFAULT == null ? documentFormat != null : !DOCUMENT_FORMAT_EDEFAULT.equals(documentFormat);
			case PSMDocPackage.DOCUMENT__DOCUMENT_FORMAT_CODE:
				return DOCUMENT_FORMAT_CODE_EDEFAULT == null ? documentFormatCode != null : !DOCUMENT_FORMAT_CODE_EDEFAULT.equals(documentFormatCode);
			case PSMDocPackage.DOCUMENT__PAGES:
				return pages != null && !pages.isEmpty();
			case PSMDocPackage.DOCUMENT__DOCUMENT_PLATFORM:
				return DOCUMENT_PLATFORM_EDEFAULT == null ? documentPlatform != null : !DOCUMENT_PLATFORM_EDEFAULT.equals(documentPlatform);
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
		result.append(", documentFormat: ");
		result.append(documentFormat);
		result.append(", documentFormatCode: ");
		result.append(documentFormatCode);
		result.append(", documentPlatform: ");
		result.append(documentPlatform);
		result.append(')');
		return result.toString();
	}

} //DocumentImpl
