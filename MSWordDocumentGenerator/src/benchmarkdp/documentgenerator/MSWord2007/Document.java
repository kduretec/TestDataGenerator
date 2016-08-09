/**
 */
package benchmarkdp.documentgenerator.MSWord2007;

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
 *   <li>{@link benchmarkdp.documentgenerator.MSWord2007.Document#getName <em>Name</em>}</li>
 *   <li>{@link benchmarkdp.documentgenerator.MSWord2007.Document#getAuthor <em>Author</em>}</li>
 *   <li>{@link benchmarkdp.documentgenerator.MSWord2007.Document#getPages <em>Pages</em>}</li>
 *   <li>{@link benchmarkdp.documentgenerator.MSWord2007.Document#getNumColum <em>Num Colum</em>}</li>
 *   <li>{@link benchmarkdp.documentgenerator.MSWord2007.Document#getFormat <em>Format</em>}</li>
 *   <li>{@link benchmarkdp.documentgenerator.MSWord2007.Document#getFormatCode <em>Format Code</em>}</li>
 * </ul>
 *
 * @see benchmarkdp.documentgenerator.MSWord2007.MSWordPackage#getDocument()
 * @model
 * @generated
 */
public interface Document extends EObject {
	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see benchmarkdp.documentgenerator.MSWord2007.MSWordPackage#getDocument_Name()
	 * @model
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link benchmarkdp.documentgenerator.MSWord2007.Document#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Author</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Author</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Author</em>' attribute.
	 * @see #setAuthor(String)
	 * @see benchmarkdp.documentgenerator.MSWord2007.MSWordPackage#getDocument_Author()
	 * @model
	 * @generated
	 */
	String getAuthor();

	/**
	 * Sets the value of the '{@link benchmarkdp.documentgenerator.MSWord2007.Document#getAuthor <em>Author</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Author</em>' attribute.
	 * @see #getAuthor()
	 * @generated
	 */
	void setAuthor(String value);

	/**
	 * Returns the value of the '<em><b>Pages</b></em>' containment reference list.
	 * The list contents are of type {@link benchmarkdp.documentgenerator.MSWord2007.Page}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Pages</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Pages</em>' containment reference list.
	 * @see benchmarkdp.documentgenerator.MSWord2007.MSWordPackage#getDocument_Pages()
	 * @model containment="true"
	 * @generated
	 */
	EList<Page> getPages();

	/**
	 * Returns the value of the '<em><b>Num Colum</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Num Colum</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Num Colum</em>' attribute.
	 * @see #setNumColum(int)
	 * @see benchmarkdp.documentgenerator.MSWord2007.MSWordPackage#getDocument_NumColum()
	 * @model
	 * @generated
	 */
	int getNumColum();

	/**
	 * Sets the value of the '{@link benchmarkdp.documentgenerator.MSWord2007.Document#getNumColum <em>Num Colum</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Num Colum</em>' attribute.
	 * @see #getNumColum()
	 * @generated
	 */
	void setNumColum(int value);

	/**
	 * Returns the value of the '<em><b>Format</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Format</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Format</em>' attribute.
	 * @see #setFormat(String)
	 * @see benchmarkdp.documentgenerator.MSWord2007.MSWordPackage#getDocument_Format()
	 * @model
	 * @generated
	 */
	String getFormat();

	/**
	 * Sets the value of the '{@link benchmarkdp.documentgenerator.MSWord2007.Document#getFormat <em>Format</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Format</em>' attribute.
	 * @see #getFormat()
	 * @generated
	 */
	void setFormat(String value);

	/**
	 * Returns the value of the '<em><b>Format Code</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Format Code</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Format Code</em>' attribute.
	 * @see #setFormatCode(String)
	 * @see benchmarkdp.documentgenerator.MSWord2007.MSWordPackage#getDocument_FormatCode()
	 * @model
	 * @generated
	 */
	String getFormatCode();

	/**
	 * Sets the value of the '{@link benchmarkdp.documentgenerator.MSWord2007.Document#getFormatCode <em>Format Code</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Format Code</em>' attribute.
	 * @see #getFormatCode()
	 * @generated
	 */
	void setFormatCode(String value);

} // Document
