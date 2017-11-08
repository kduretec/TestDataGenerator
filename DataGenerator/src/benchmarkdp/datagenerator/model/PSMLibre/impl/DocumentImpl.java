/**
 */
package benchmarkdp.datagenerator.model.PSMLibre.impl;

import benchmarkdp.datagenerator.model.PSMLibre.Color;
import benchmarkdp.datagenerator.model.PSMLibre.Document;
import benchmarkdp.datagenerator.model.PSMLibre.PSMLibrePackage;
import benchmarkdp.datagenerator.model.PSMLibre.Page;

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
 *   <li>{@link benchmarkdp.datagenerator.model.PSMLibre.impl.DocumentImpl#getPages <em>Pages</em>}</li>
 *   <li>{@link benchmarkdp.datagenerator.model.PSMLibre.impl.DocumentImpl#getDocumentBackground <em>Document Background</em>}</li>
 *   <li>{@link benchmarkdp.datagenerator.model.PSMLibre.impl.DocumentImpl#getDocumentFormat <em>Document Format</em>}</li>
 *   <li>{@link benchmarkdp.datagenerator.model.PSMLibre.impl.DocumentImpl#getDocumentFilter <em>Document Filter</em>}</li>
 *   <li>{@link benchmarkdp.datagenerator.model.PSMLibre.impl.DocumentImpl#getSoftware <em>Software</em>}</li>
 *   <li>{@link benchmarkdp.datagenerator.model.PSMLibre.impl.DocumentImpl#getOperatingSystem <em>Operating System</em>}</li>
 * </ul>
 *
 * @generated
 */
public class DocumentImpl extends MinimalEObjectImpl.Container implements Document {
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
	 * The default value of the '{@link #getDocumentBackground() <em>Document Background</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDocumentBackground()
	 * @generated
	 * @ordered
	 */
	protected static final Color DOCUMENT_BACKGROUND_EDEFAULT = Color.WHITE;

	/**
	 * The cached value of the '{@link #getDocumentBackground() <em>Document Background</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDocumentBackground()
	 * @generated
	 * @ordered
	 */
	protected Color documentBackground = DOCUMENT_BACKGROUND_EDEFAULT;

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
	 * The default value of the '{@link #getDocumentFilter() <em>Document Filter</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDocumentFilter()
	 * @generated
	 * @ordered
	 */
	protected static final String DOCUMENT_FILTER_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getDocumentFilter() <em>Document Filter</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDocumentFilter()
	 * @generated
	 * @ordered
	 */
	protected String documentFilter = DOCUMENT_FILTER_EDEFAULT;

	/**
	 * The default value of the '{@link #getSoftware() <em>Software</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSoftware()
	 * @generated
	 * @ordered
	 */
	protected static final String SOFTWARE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getSoftware() <em>Software</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSoftware()
	 * @generated
	 * @ordered
	 */
	protected String software = SOFTWARE_EDEFAULT;

	/**
	 * The default value of the '{@link #getOperatingSystem() <em>Operating System</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOperatingSystem()
	 * @generated
	 * @ordered
	 */
	protected static final String OPERATING_SYSTEM_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getOperatingSystem() <em>Operating System</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOperatingSystem()
	 * @generated
	 * @ordered
	 */
	protected String operatingSystem = OPERATING_SYSTEM_EDEFAULT;

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
		return PSMLibrePackage.Literals.DOCUMENT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Page> getPages() {
		if (pages == null) {
			pages = new EObjectContainmentEList<Page>(Page.class, this, PSMLibrePackage.DOCUMENT__PAGES);
		}
		return pages;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Color getDocumentBackground() {
		return documentBackground;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDocumentBackground(Color newDocumentBackground) {
		Color oldDocumentBackground = documentBackground;
		documentBackground = newDocumentBackground == null ? DOCUMENT_BACKGROUND_EDEFAULT : newDocumentBackground;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PSMLibrePackage.DOCUMENT__DOCUMENT_BACKGROUND, oldDocumentBackground, documentBackground));
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
			eNotify(new ENotificationImpl(this, Notification.SET, PSMLibrePackage.DOCUMENT__DOCUMENT_FORMAT, oldDocumentFormat, documentFormat));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getDocumentFilter() {
		return documentFilter;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDocumentFilter(String newDocumentFilter) {
		String oldDocumentFilter = documentFilter;
		documentFilter = newDocumentFilter;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PSMLibrePackage.DOCUMENT__DOCUMENT_FILTER, oldDocumentFilter, documentFilter));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getSoftware() {
		return software;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSoftware(String newSoftware) {
		String oldSoftware = software;
		software = newSoftware;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PSMLibrePackage.DOCUMENT__SOFTWARE, oldSoftware, software));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getOperatingSystem() {
		return operatingSystem;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOperatingSystem(String newOperatingSystem) {
		String oldOperatingSystem = operatingSystem;
		operatingSystem = newOperatingSystem;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PSMLibrePackage.DOCUMENT__OPERATING_SYSTEM, oldOperatingSystem, operatingSystem));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case PSMLibrePackage.DOCUMENT__PAGES:
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
			case PSMLibrePackage.DOCUMENT__PAGES:
				return getPages();
			case PSMLibrePackage.DOCUMENT__DOCUMENT_BACKGROUND:
				return getDocumentBackground();
			case PSMLibrePackage.DOCUMENT__DOCUMENT_FORMAT:
				return getDocumentFormat();
			case PSMLibrePackage.DOCUMENT__DOCUMENT_FILTER:
				return getDocumentFilter();
			case PSMLibrePackage.DOCUMENT__SOFTWARE:
				return getSoftware();
			case PSMLibrePackage.DOCUMENT__OPERATING_SYSTEM:
				return getOperatingSystem();
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
			case PSMLibrePackage.DOCUMENT__PAGES:
				getPages().clear();
				getPages().addAll((Collection<? extends Page>)newValue);
				return;
			case PSMLibrePackage.DOCUMENT__DOCUMENT_BACKGROUND:
				setDocumentBackground((Color)newValue);
				return;
			case PSMLibrePackage.DOCUMENT__DOCUMENT_FORMAT:
				setDocumentFormat((String)newValue);
				return;
			case PSMLibrePackage.DOCUMENT__DOCUMENT_FILTER:
				setDocumentFilter((String)newValue);
				return;
			case PSMLibrePackage.DOCUMENT__SOFTWARE:
				setSoftware((String)newValue);
				return;
			case PSMLibrePackage.DOCUMENT__OPERATING_SYSTEM:
				setOperatingSystem((String)newValue);
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
			case PSMLibrePackage.DOCUMENT__PAGES:
				getPages().clear();
				return;
			case PSMLibrePackage.DOCUMENT__DOCUMENT_BACKGROUND:
				setDocumentBackground(DOCUMENT_BACKGROUND_EDEFAULT);
				return;
			case PSMLibrePackage.DOCUMENT__DOCUMENT_FORMAT:
				setDocumentFormat(DOCUMENT_FORMAT_EDEFAULT);
				return;
			case PSMLibrePackage.DOCUMENT__DOCUMENT_FILTER:
				setDocumentFilter(DOCUMENT_FILTER_EDEFAULT);
				return;
			case PSMLibrePackage.DOCUMENT__SOFTWARE:
				setSoftware(SOFTWARE_EDEFAULT);
				return;
			case PSMLibrePackage.DOCUMENT__OPERATING_SYSTEM:
				setOperatingSystem(OPERATING_SYSTEM_EDEFAULT);
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
			case PSMLibrePackage.DOCUMENT__PAGES:
				return pages != null && !pages.isEmpty();
			case PSMLibrePackage.DOCUMENT__DOCUMENT_BACKGROUND:
				return documentBackground != DOCUMENT_BACKGROUND_EDEFAULT;
			case PSMLibrePackage.DOCUMENT__DOCUMENT_FORMAT:
				return DOCUMENT_FORMAT_EDEFAULT == null ? documentFormat != null : !DOCUMENT_FORMAT_EDEFAULT.equals(documentFormat);
			case PSMLibrePackage.DOCUMENT__DOCUMENT_FILTER:
				return DOCUMENT_FILTER_EDEFAULT == null ? documentFilter != null : !DOCUMENT_FILTER_EDEFAULT.equals(documentFilter);
			case PSMLibrePackage.DOCUMENT__SOFTWARE:
				return SOFTWARE_EDEFAULT == null ? software != null : !SOFTWARE_EDEFAULT.equals(software);
			case PSMLibrePackage.DOCUMENT__OPERATING_SYSTEM:
				return OPERATING_SYSTEM_EDEFAULT == null ? operatingSystem != null : !OPERATING_SYSTEM_EDEFAULT.equals(operatingSystem);
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
		result.append(" (documentBackground: ");
		result.append(documentBackground);
		result.append(", documentFormat: ");
		result.append(documentFormat);
		result.append(", documentFilter: ");
		result.append(documentFilter);
		result.append(", software: ");
		result.append(software);
		result.append(", operatingSystem: ");
		result.append(operatingSystem);
		result.append(')');
		return result.toString();
	}

} //DocumentImpl
