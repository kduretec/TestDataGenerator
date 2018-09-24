/**
 */
package benchmarkdp.datagenerator.model.PSMLibre;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Document</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link benchmarkdp.datagenerator.model.PSMLibre.Document#getPages <em>Pages</em>}</li>
 *   <li>{@link benchmarkdp.datagenerator.model.PSMLibre.Document#getDocumentBackground <em>Document Background</em>}</li>
 *   <li>{@link benchmarkdp.datagenerator.model.PSMLibre.Document#getDocumentFormat <em>Document Format</em>}</li>
 *   <li>{@link benchmarkdp.datagenerator.model.PSMLibre.Document#getDocumentFilter <em>Document Filter</em>}</li>
 *   <li>{@link benchmarkdp.datagenerator.model.PSMLibre.Document#getSoftware <em>Software</em>}</li>
 *   <li>{@link benchmarkdp.datagenerator.model.PSMLibre.Document#getOperatingSystem <em>Operating System</em>}</li>
 *   <li>{@link benchmarkdp.datagenerator.model.PSMLibre.Document#isCalcLayout <em>Calc Layout</em>}</li>
 * </ul>
 *
 * @see benchmarkdp.datagenerator.model.PSMLibre.PSMLibrePackage#getDocument()
 * @model
 * @generated
 */
public interface Document extends EObject {
	/**
	 * Returns the value of the '<em><b>Pages</b></em>' containment reference list.
	 * The list contents are of type {@link benchmarkdp.datagenerator.model.PSMLibre.Page}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Pages</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Pages</em>' containment reference list.
	 * @see benchmarkdp.datagenerator.model.PSMLibre.PSMLibrePackage#getDocument_Pages()
	 * @model containment="true"
	 * @generated
	 */
	EList<Page> getPages();

	/**
	 * Returns the value of the '<em><b>Document Background</b></em>' attribute.
	 * The default value is <code>"WHITE"</code>.
	 * The literals are from the enumeration {@link benchmarkdp.datagenerator.model.PSMLibre.Color}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Document Background</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Document Background</em>' attribute.
	 * @see benchmarkdp.datagenerator.model.PSMLibre.Color
	 * @see #setDocumentBackground(Color)
	 * @see benchmarkdp.datagenerator.model.PSMLibre.PSMLibrePackage#getDocument_DocumentBackground()
	 * @model default="WHITE"
	 * @generated
	 */
	Color getDocumentBackground();

	/**
	 * Sets the value of the '{@link benchmarkdp.datagenerator.model.PSMLibre.Document#getDocumentBackground <em>Document Background</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Document Background</em>' attribute.
	 * @see benchmarkdp.datagenerator.model.PSMLibre.Color
	 * @see #getDocumentBackground()
	 * @generated
	 */
	void setDocumentBackground(Color value);

	/**
	 * Returns the value of the '<em><b>Document Format</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Document Format</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Document Format</em>' attribute.
	 * @see #setDocumentFormat(String)
	 * @see benchmarkdp.datagenerator.model.PSMLibre.PSMLibrePackage#getDocument_DocumentFormat()
	 * @model
	 * @generated
	 */
	String getDocumentFormat();

	/**
	 * Sets the value of the '{@link benchmarkdp.datagenerator.model.PSMLibre.Document#getDocumentFormat <em>Document Format</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Document Format</em>' attribute.
	 * @see #getDocumentFormat()
	 * @generated
	 */
	void setDocumentFormat(String value);

	/**
	 * Returns the value of the '<em><b>Document Filter</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Document Filter</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Document Filter</em>' attribute.
	 * @see #setDocumentFilter(String)
	 * @see benchmarkdp.datagenerator.model.PSMLibre.PSMLibrePackage#getDocument_DocumentFilter()
	 * @model
	 * @generated
	 */
	String getDocumentFilter();

	/**
	 * Sets the value of the '{@link benchmarkdp.datagenerator.model.PSMLibre.Document#getDocumentFilter <em>Document Filter</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Document Filter</em>' attribute.
	 * @see #getDocumentFilter()
	 * @generated
	 */
	void setDocumentFilter(String value);

	/**
	 * Returns the value of the '<em><b>Software</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Software</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Software</em>' attribute.
	 * @see #setSoftware(String)
	 * @see benchmarkdp.datagenerator.model.PSMLibre.PSMLibrePackage#getDocument_Software()
	 * @model
	 * @generated
	 */
	String getSoftware();

	/**
	 * Sets the value of the '{@link benchmarkdp.datagenerator.model.PSMLibre.Document#getSoftware <em>Software</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Software</em>' attribute.
	 * @see #getSoftware()
	 * @generated
	 */
	void setSoftware(String value);

	/**
	 * Returns the value of the '<em><b>Operating System</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Operating System</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Operating System</em>' attribute.
	 * @see #setOperatingSystem(String)
	 * @see benchmarkdp.datagenerator.model.PSMLibre.PSMLibrePackage#getDocument_OperatingSystem()
	 * @model
	 * @generated
	 */
	String getOperatingSystem();

	/**
	 * Sets the value of the '{@link benchmarkdp.datagenerator.model.PSMLibre.Document#getOperatingSystem <em>Operating System</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Operating System</em>' attribute.
	 * @see #getOperatingSystem()
	 * @generated
	 */
	void setOperatingSystem(String value);

	/**
	 * Returns the value of the '<em><b>Calc Layout</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Calc Layout</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Calc Layout</em>' attribute.
	 * @see #setCalcLayout(boolean)
	 * @see benchmarkdp.datagenerator.model.PSMLibre.PSMLibrePackage#getDocument_CalcLayout()
	 * @model
	 * @generated
	 */
	boolean isCalcLayout();

	/**
	 * Sets the value of the '{@link benchmarkdp.datagenerator.model.PSMLibre.Document#isCalcLayout <em>Calc Layout</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Calc Layout</em>' attribute.
	 * @see #isCalcLayout()
	 * @generated
	 */
	void setCalcLayout(boolean value);

} // Document
