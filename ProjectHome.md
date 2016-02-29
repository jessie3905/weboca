# Introduction to WeBoCa #

WeBoCa is an advanced and altered implementation of JBootCat (a Java implemention of the BootCat scripts written by Marco Baroni et al for acquiring corpora from the Internet).  Written by Michael Drayson, WeBoCa will allow users to create a corpus from a range of search engines, and then conduct processing on the corpus in order to tidy up / manipulate the corpus in a range of ways.

The BootCat scripts are of great interest to linguists, translators and anyone researching such techniques for academic purposes.

While the main goal of JBootCat was 'to encapsulate the BootCat functionality within a user-friendly desktop application', WeBoCa looks to improve upon the open-source application, and increase its functionality in terms of both corpus collection, and knowledge discovery from within the corpus created.

The application is now in a state ready for public release.

# WeBoCa Features #

WeBoCa includes the following features:

  * Vertical / Horizontal corpus creation
  * Google / Yahoo search engine implementation
  * Define additional search parameters
  * Define a word limit
  * Define a page size limit
  * Save URLs used in downloading
  * Advanced URL processing including;
  * Remove stored URLs as terms
  * Remove non alpha-numerical terms
  * Sort corpus
  * Convert corpus terms to lower case
  * Remove non-unique corpus terms
  * Generate frequency count

# Running WeBoCa #

In order to run WeBoCa, first please ensure you have the Java Virtual Environment 1.4 or greater installed.  Then, if using Windows download the latest WeBoCa Windows executable archive.  If prefered, or using non-Windows system, download the latest WeBoCa Distribution release, navigate to extracted folder and type 'java -jar WeBoCa.jar' at the terminal.

You can also access the latest WeBoCa source code by connecting to it's Subversion (SVN) repository from your favourite IDE.  WeBoCa was developed in Netbeans with the SVN pluggin and this is the recommended IDE.

Any issues or problems? Contact Michael Drayson at weboca.info@gmail.com

# Version History #
  * 1.2 Fixed String bug on Get URLs button, and corrected GUI errors
  * 1.1 Fixed String bug, optimised file loading and processing algorithms
  * 1.0 Initial public release