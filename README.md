# jRAT Reverse SOCKS Plugin

A Reverse SOCKS proxy which will allow you to connect to internet through remote machine

| Information	| Value
| ---           |:---
| Name			| Reverse SOCKS
| Author     	| jRAT
| Description   | Connect to internet through remote machine
| Version		| 1.0

## Packets

| Packet Name	| Header
| ---           |:---
| START			| 118
| STOP			| 119

## Dependencies

- Client
	- [API](https://github.com/java-rat/jrat-api)
	- [iconlib](https://github.com/redpois0n/iconlib)
	- [jsocks](http://jsocks.sourceforge.net/) (Customized version for reverse connecting included)

- Stub
	- [Stub API](https://github.com/java-rat/jrat-stub-api)
	- [jsocks](http://jsocks.sourceforge.net/) (Customized version for reverse connecting included)