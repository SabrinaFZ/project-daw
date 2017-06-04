echo "Installing Tomcat.."
sudo apt-get install -y tomcat7

echo "Copy file to Tomcat server"
sudo cp /vagrant/target/iRentMovies.war /var/lib/tomcat7/webapps/

# echo "Start Application"
# sudo java -jar /var/lib/tomcat7/webapps/iRentMovies.war

echo "Restart Tomcat"
sudo service tomcat7 restart

echo "Go to the app: http://192.168.33.10:8080/iRentMovies/"
