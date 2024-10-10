package com.iut.banque.modele;

import java.util.Base64;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

import com.iut.banque.exceptions.IllegalFormatException;

/**
 * Classe représentant un utilisateur quelconque.
 * 
 * La stratégie d'héritage choisie est SINGLE_TABLE. Cela signifie que tous les
 * objets de cette classe et des classes filles sont enregistrés dans une seule
 * table dans la base de donnée. Les champs non utilisés par la classe sont
 * NULL.
 * 
 * Lors d'un chargement d'un objet appartenant à une des classes filles, le type
 * de l'objet est choisi grâce à la colonne "type" (c'est une colonne de
 * discrimination).
 */
@Entity
@Table(name = "Utilisateur")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "type", discriminatorType = DiscriminatorType.STRING, length = 15)
public abstract class Utilisateur {

	/**
	 * L'identifiant (unique) de l'utilisateur.
	 * 
	 * Correspond à la clé primaire de l'utilisateur dans la BDD.
	 */
	@Id
	@Column(name = "userId")
	private String userId;

	/**
	 * Le mot de passe de l'utilisateur.
	 * 
	 */
	@Column(name = "userPwd")
	private String userPwd;

	/**
	 * Le nom de l'utilisateur.
	 */
	@Column(name = "nom")
	private String nom;

	/**
	 * Le prénom de l'utilisateur.
	 */
	@Column(name = "prenom")
	private String prenom;

	/**
	 * L'adresse physique de l'utilisateur.
	 */
	@Column(name = "adresse")
	private String adresse;

	/**
	 * Le sexe de l'utilisateur. Vrai si c'est un homme faux sinon.
	 */
	@Column(name = "male")
	private boolean male;

	/**
	 * @return String, le nom de l'utilisateur.
	 */
	public String getNom() {
		return nom;
	}

	/**
	 * @param nom
	 *            : le nom de l'utilisateur
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}

	/**
	 * @return String, le prénom de l'utilisateur
	 */
	public String getPrenom() {
		return prenom;
	}

	/**
	 * @param prenom
	 *            : le prénom de l'utilisateur
	 */
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	/**
	 * @return String, l'adresse physique de l'utilisateur
	 */
	public String getAdresse() {
		return adresse;
	}

	/**
	 * @param adresse
	 *            : l'adresse physique de l'utilisateur
	 */
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	/**
	 * @return male : vrai si l'utilisateur est un homme, faux sinon
	 */
	public boolean isMale() {
		return male;
	}

	/**
	 * @param male
	 *            : vrai si l'utilisateur est un homme, faux sinon
	 */
	public void setMale(boolean male) {
		this.male = male;
	}

	/**
	 * @return userId : l'identifiant de l'utilisateur
	 */
	public String getUserId() {
		return userId;
	}

	/**
	 * @param userId
	 *            : l'identifiant de l'utilisateur
	 * @throws IllegalFormatException
	 */
	public void setUserId(String userId) throws IllegalFormatException {
		this.userId = userId;
	}

	/**
	 * @return userPwd : le mot de passe de l'utilisateur
	 */
	private static final String ALGORITHM = "AES"; // Algorithme de chiffrement
    private static final String KEY = "0123456789abcdef"; // Clé AES de 16 caractères (128 bits)

    // Méthode pour obtenir le mot de passe déchiffré
    public String getUserPwd() {
        String decryptPwd = "";
        try {
            decryptPwd = Utilisateur.decrypt(userPwd); // Déchiffre le mot de passe
            System.out.println("Mot de passe chiffré : " + userPwd); // Affiche le mot de passe chiffré<
			System.out.println("Mot de passe dechiffré : " + decryptPwd); // Affiche le mot de passe chiffré<
			System.out.println("Mot de passe apres etre chiffré : " + Utilisateur.encrypt(userPwd)); // Affiche le mot de passe chiffré<
        } catch (Exception e) {
            e.printStackTrace();
        }
		return decryptPwd;
        // return userPwd;
    }

    /**
     * Méthode pour définir le mot de passe de l'utilisateur
     *
     * @param userPwd : le mot de passe de l'utilisateur
     */
    public void setUserPwd(String userPwd) {
        try {
            this.userPwd = Utilisateur.encrypt(userPwd); // Chiffre le mot de passe et le stocke
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Fonction pour chiffrer le mot de passe
    public static String encrypt(String password) throws Exception {
        SecretKeySpec keySpec = new SecretKeySpec(KEY.getBytes(), ALGORITHM); // Convertit la clé en bytes
        Cipher cipher = Cipher.getInstance(ALGORITHM); // Initialisation du Cipher avec l'algorithme AES
        cipher.init(Cipher.ENCRYPT_MODE, keySpec); // Mode chiffrement

        byte[] encryptedBytes = cipher.doFinal(password.getBytes()); // Chiffre le mot de passe
        return Base64.getEncoder().encodeToString(encryptedBytes); // Encode en base64 pour l'affichage
    }

    // Fonction pour déchiffrer le mot de passe
    public static String decrypt(String encryptedPassword) throws Exception {
        SecretKeySpec keySpec = new SecretKeySpec(KEY.getBytes(), ALGORITHM); // Recrée la clé
        Cipher cipher = Cipher.getInstance(ALGORITHM);
        cipher.init(Cipher.DECRYPT_MODE, keySpec); // Mode déchiffrement

        byte[] decodedBytes = Base64.getDecoder().decode(encryptedPassword); // Décoder le base64
        byte[] decryptedBytes = cipher.doFinal(decodedBytes); // Déchiffre le mot de passe
        return new String(decryptedBytes); // Convertit en chaîne de caractères
    }



	/**
	 * Constructeur de Utilisateur avec tous les champs de la classe comme
	 * paramètres.
	 * 
	 * Il est préférable d'utiliser une classe implémentant IDao pour créer un
	 * objet au lieu d'appeler ce constructeur.
	 * 
	 * @param nom
	 * @param prenom
	 * @param adresse
	 * @param male
	 * @param userId
	 * @param userPwd
	 */
	public Utilisateur(String nom, String prenom, String adresse, boolean male, String userId, String userPwd) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.adresse = adresse;
		this.male = male;
		this.userId = userId;
		this.userPwd = userPwd;
	}

	/**
	 * Constructeur sans paramètre de Utilisateur.
	 * 
	 * Nécessaire pour Hibernate.
	 *
	 * Il est préférable d'utiliser une classe implémentant IDao pour créer un
	 * objet au lieu d'appeler ce constructeur.
	 */
	public Utilisateur() {
		super();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Utilisateur [userId=" + userId + ", nom=" + nom + ", prenom=" + prenom + ", adresse=" + adresse
				+ ", male=" + male + ", userPwd=" + userPwd + "]";
	}

}
