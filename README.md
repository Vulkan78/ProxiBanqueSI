# Guide d'installation / d'utilisation de l'application Java ProxiBanqueSI

## Vérifiez que le livrable est composé des éléments suivants :
	- BDDProxiBanqueSI : fichier SQL comportant la base de donées
	- Dossier "src" : code source de l'application
	- Dossier "UML" : contient les diagrammes UML suivant : classes, déploiement, et cas d'utilisation + le sitemap
	- Dossier "Javadoc"

## Technologies et version utilisées :
	- Java : 1.8
	- Hibernate 5.4.2
	- Junit : 4.12
	- Maven 3.5.2
	- MySQL : 5.1.36
	- Tomcat : 8.5.24
	- PhpMyAdmin

### Pré-requis
	- **Installez le JDK 8** sur la machine cible,
	- Téléchargez le depuis: *http://www.oracle.com/technetwork/java/javase/downloads/index.html*

### ETAPE 1
## Importer la base de données
	- Sur PhpMyAdmin, importez le fichier BDDProxiBanqueSI.sql

### Etape 2
## Générer le .war
	- A partir de votre IDE, lancez la commande "mvn clean install"
	- Un dossier target est crée avec le .war
	- Déposez le .war dans le dossier "Webapp" de votre serveur Tomcat
	- Démarez votre server Tomcat
	- Ouvrir votre navigateur et entrez l'url suivante : http://localhost:8080

### ETAPE 3
## Naviguer au sein de l'application
	- La 1er page sur laquelle vous arriverez est la page d'authentification
			- En V5, cliquez simplement sur "Connexion" pour accéder à l'application, le module d'authentification n'étant pas encore totalement géré.
	- Une fois "connecté", la page "Que voulez-vous faire ?" permet de choisir parmis les actions suivantes :
		- Consulter la liste des clients
			- Affiche les informations client
			- Permet d'accéder au profil de chaque client
			- De les éditer
		- Consulter la Liste des conseillers
				- Affiche les informations client
			- Permet d'accéder au profil de chaque client
			- De les éditer

	- La barre de navigation vous permet :
		- De créer un nouveau client
		- De créer un nouveau conseiller
		- De vous "déconnecter"


## Consulter la documentation JavaDoc:
- Double-cliquer sur le fichier *index.html* se trouvant dans le repertoire *Javadoc*
