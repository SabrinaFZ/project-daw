TARGET = libyajl
DLLIB = $(TARGET).so
all:

install:
	mkdir -p /opt/chef/embedded/lib/ruby/gems/2.4.0/gems/libyajl2-1.2.0/lib/libyajl2/vendored-libyajl2/lib
	cp $(DLLIB) /opt/chef/embedded/lib/ruby/gems/2.4.0/gems/libyajl2-1.2.0/lib/libyajl2/vendored-libyajl2/lib/$(DLLIB)
	mkdir -p /opt/chef/embedded/lib/ruby/gems/2.4.0/gems/libyajl2-1.2.0/lib/libyajl2/vendored-libyajl2/include/yajl
	cp yajl/*.h /opt/chef/embedded/lib/ruby/gems/2.4.0/gems/libyajl2-1.2.0/lib/libyajl2/vendored-libyajl2/include/yajl
