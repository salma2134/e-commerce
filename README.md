# E-commerce JEE

## Description

Ce projet consiste à développer une application web de commerce électronique (E-commerce) en utilisant les technologies Java EE / Jakarta EE.

L'application permet aux internautes de consulter les produits disponibles,  de créer un compte, de se connecter et de gérer leur panier. 
Elle propose également une interface d'administration pour gérer les produits.

## Fonctionnalités

### Espace internaute
- Inscription d'un nouvel internaute.
- Connexion et déconnexion.
- Consultation de la vitrine des produits.
- Ajout de produits au panier.
- Consultation du panier.
- Suppression de produits du panier.
- Calcul automatique du total du panier.

### Espace administrateur
- Ajout de nouveaux produits.
- Affichage de la liste des produits.
- Suppression de produits.

## Architecture du projet

Le projet suit une architecture en couches :

- **Model** : contient les entités JPA (`Internaute`, `Produit`, `Panier`, `LignePanier`, `Categorie`, `Vitrine`).
- **Bean** : contient les ManagedBeans qui assurent la gestion des fonctionnalités.
- **View** : contient les pages XHTML qui constituent l'interface utilisateur.
- **Persistence** : contient la configuration JPA et la gestion des connexions à la base de données.

## Pages principales

| Page | Description |
|---|---|
| `index.xhtml` | Page d'accueil |
| `inscription.xhtml` | Inscription d'un internaute |
| `login.xhtml` | Connexion |
| `vitrine.xhtml` | Affichage des produits |
| `panier.xhtml` | Gestion du panier |
| `admin.xhtml` | Administration des produits |

## Installation et exécution

### 1. Prérequis

- JDK compatible avec le projet.
- Eclipse IDE.
- Apache Maven.
- Apache Tomcat compatible avec la version de JSF utilisée.
- MySQL Server.

### 2. Cloner le projet

```bash
git clone https://github.com/salma2134/e-commerce.git
```

### 3. Configurer la base de données

- Démarrer MySQL.
- Créer la base de données utilisée par le projet.
- Configurer les paramètres de connexion dans `persistence.xml`.

### 4. Importer le projet dans Eclipse

1. Ouvrir Eclipse.
2. Sélectionner `File > Import`.
3. Choisir `Existing Maven Projects`.
4. Sélectionner le dossier du projet.
5. Cliquer sur `Finish`.

### 5. Exécuter l'application

1. Configurer Apache Tomcat dans Eclipse.
2. Ajouter le projet au serveur.
3. Démarrer le serveur.
4. Accéder à l'application depuis le navigateur.



Atelier 3 — Développement d'une application web E-commerce avec Java EE.
