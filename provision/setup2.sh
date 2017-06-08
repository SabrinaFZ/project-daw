echo "Installing Tomcat.."
sudo apt-get install -y tomcat7

echo "Install mysql client and server"
debconf-set-selections <<< 'mysql-server-5.5 mysql-server/root_password password root'
debconf-set-selections <<< 'mysql-server-5.5 mysql-server/root_password_again password root'
apt-get -y install mysql-server
apt-get -y install mysql-client

echo "configuring mysql networking"
sudo cp /vagrant/provision/my.cnf /etc/mysql/my.cnf
service mysql restart

echo "creating mysql user"
mysql -uroot -proot -e "GRANT ALL PRIVILEGES ON *.* TO root@'localhost' IDENTIFIED BY 'root' WITH GRANT OPTION;"
mysql -uroot -proot -e "GRANT ALL PRIVILEGES ON *.* TO root@'%'         IDENTIFIED BY 'root' WITH GRANT OPTION;"

echo "create iRentMovies Database"
mysql -uroot -proot < /vagrant/provision/db.sql


echo "Copy file to Tomcat server"
sudo cp /vagrant/target/iRentMovies.war /var/lib/tomcat7/webapps/

# echo "Start Application"
# sudo java -jar /var/lib/tomcat7/webapps/iRentMovies.war

echo "Restart Tomcat"
sudo service tomcat7 restart

echo "Go to the app: http://192.168.33.11:8080/iRentMovies/"
