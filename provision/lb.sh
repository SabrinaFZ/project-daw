$script = <<SCRIPT
sudo apt-get install -y haproxy
sudo sed -i 's/ENABLED=0/ENABLED=1/g' /etc/default/haproxy
sudo cp /vagrant/data/haproxy.cfg /etc/haproxy/haproxy.cfg
sudo service apache2 stop
sudo service haproxy restart
SCRIPT
