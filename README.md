Benchmark Test
==============

### Installing Redis Node
```
#!/bin/bash
#---------------------------------------------------------------------------#
yum install vim -y
yum install epel-release
yum install redis -y
#---------------------------------------------------------------------------#
INTERNAL_IP_ADDRESS=`ifconfig | grep -Eo 'inet (addr:)?([0-9]*\.){3}[0-9]*' | \
        grep -Eo '([0-9]*\.){3}[0-9]*' | grep -v '127.0.0.1'`
sed -i "s/bind 127.0.0.1/bind $INTERNAL_IP_ADDRESS/" /etc/redis.conf

#---------------------------------------------------------------------------#
systemctl start redis.service
systemctl enable redis
systemctl status redis.service
#---------------------------------------------------------------------------#
```


### Bentchmark Result on Local Virtual Machines
```
Storing Key and Value on [ Node:3 IP = 192.168.0.29 ]

Key = wflnnxbrusnbufrlboruxrvpqctslgbt
HashedKey = 1a56931853ecaaa3968737fd3efb7a041f9b6f6181416f7494ef45eb36dd9033
Value = rxuqhxqtuufugckinoqadwgegwuwefwecgpfjcxevttkduiwpelihrhdajmitlrp
-----------------------------------------------------------------------
Storing Key and Value on [ Node:3 IP = 192.168.0.29 ]

Key = teprfgbbedtarxoqutvqrgxwbgruemhr
HashedKey = 0218b0c722dfd8256743930e30ba68c501e634fca949515ffa079676172bb083
Value = inhpbvdevhjcspqcpqbgebilgcvvlmlmohvnafqemtbuuqdbfgummwwodqnavhkx
-----------------------------------------------------------------------
Storing Key and Value on [ Node:7 IP = 192.168.0.26 ]

Key = rllfwiecumwkcgkpkklpfrnrmvwrecpd
HashedKey = fd7b82ce31388f5622f4f35f2b1d889a622d2aea8065350d3c0ce4fd1c713187
Value = fhoupmudsowpqwskjpqtdwssmucuoxggfxkwautubmdidcwgpsqetrreikoeodut
-----------------------------------------------------------------------
Storing Key and Value on [ Node:
Key = gototdwrotlbvptfqphviwmdldvgakno
HashedKey = f534be531ab8d5034fe1471c042063a15818ead97c09f51f09d62e7bff362000
Value = ljvjohamvwavujmnhrrtvkcmssnoirldkluuulvlssxklvvrruscihmkjdbadcuh
-----------------------------------------------------------------------
Storing Key and Value on [ Node:1 IP = 192.168.0.29 ]

Key = mjmarccjacukoftwsnfwusqjmdeadten
HashedKey = 22cde624c6852a92f26cd3df4d19dcee4020db31515192a8218be87bd14e50d1
Value = qgjujcskltdcjprhnaalghkvwgujwgocapoljoktjqiwinmaxaouiletlxdixioa
Time Taken: 689
```
