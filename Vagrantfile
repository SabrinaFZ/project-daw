# -*- mode: ruby -*-
# vi: set ft=ruby :

Vagrant.configure('2') do |config|

  # config.vm.box = "azure"
	# config.ssh.private_key_path = '~/.ssh/id_rsa'
  config.vm.box = "atorre/daw"
  config.vm.synced_folder ".", "/vagrant"

  config.berkshelf.enabled = true
  config.omnibus.chef_version = :latest

  #config.berkshelf.berksfile_path = "./Berksfile"

	config.vm.provision :chef_solo do |chef|
    # chef.version = "12.19.36"
    # chef.cookbooks_path = "./cookbooks"
    # chef.roles_path     = "./provision/roles"
    # chef.add_role "db"
    chef.add_recipe "apt"
    chef.add_recipe "apache2"
    # chef.add_recipe "sc-mongodb"
    # chef.json = { :mongodb => { :config =>  { :mongod => { :net => { :bindIp => "192.168.33.12" } } } } }
	end

  #  do_common_azure_stuff = Proc.new do |azure, override|
  #   override.vm.synced_folder ".", "/vagrant"
  #   # each of the below values will default to use the env vars named as below if not specified explicitly
  #   azure.tenant_id = '9c40162c-3d7f-4a2e-aa17-22b7d08a9f1f'
  #   azure.client_id = '50c354c8-07e1-401e-8d00-27746dc6afdc'
  #   azure.client_secret = 'd48ae650-5552-46dd-8f4f-3493fc3322b2'
  #   azure.subscription_id = 'fef6620c-deb7-4a11-be6e-35ed4133adf8'
  #  end
   #
  #  config.vm.define 'first' do |cfg|
	# 	cfg.vm.provider :azure do |azure, override|
	# 		do_common_azure_stuff.call azure, override
	# 		azure.vm_name = 'sabdav1'
  #     cfg.vm.network :forwarded_port, guest: 80, host: 8080
  #     cfg.vm.network "public_network", ip: "10.10.10.1"
  #     cfg.vm.provision "shell", path: "./provision/setup1.sh"
  #     # cfg.vm.provision "shell", inline: $script1
	# 	end
  #  end
   #
  #  config.vm.define 'second' do |cfg|
  # 	cfg.vm.provider :azure do |azure, override|
	# 		do_common_azure_stuff.call azure, override
	# 		azure.vm_name = 'sabdav2'
  #     cfg.vm.network :forwarded_port, guest: 80, host: 8081
  #     cfg.vm.network "public_network", ip: "10.10.10.2"
  #     cfg.vm.provision "shell", path: "./provision/setup2.sh"
	# 	end
  #  end

   config.vm.define 'server1' do |cfg|
     cfg.vm.network :forwarded_port, guest: 80, host: 8080
     cfg.vm.network "private_network", ip: "192.168.33.10"
     cfg.vm.provision "shell", path: "./provision/setup1.sh"
   end

   config.vm.define 'server2' do |cfg|
      cfg.vm.network :forwarded_port, guest: 80, host: 8081
      cfg.vm.network "private_network", ip: "192.168.33.11"
      cfg.vm.provision "shell", path: "./provision/setup2.sh"
   end

   config.vm.define "lb" do |lb|
     lb.vm.network "forwarded_port", guest: 80, host: 8082
     lb.vm.network "private_network", ip: "192.168.33.20"
     lb.vm.provision "shell", path: "./provision/lb.sh"
   end

  #  config.vm.define "db" do |db|
  #    db.vm.network "private_network", ip: "192.168.33.12"
  #    db.vm.provider "virtualbox" do |vb|
  #      vb.customize ["modifyvm", :id, "--memory", "350"]
  #    end
  #  end

end
